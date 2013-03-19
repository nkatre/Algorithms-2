# Sanjay Paul (sanjayp@seas.upenn.edu)
# March 2013

# Solver for 'Nearby' Problem in the Quora Programming Challenges
# *See README for further details.

# Design Considerations:
#   (1) We need to hash locations to buckets that represent a
#       square subset of the entire grid space. The size of the
#       square subset obviously determines the total number of
#       hash buckets, which we want to keep low enough to be
#       memory efficient but high enough to avoid excessive
#       collisions.
#   (2) Serving queries for nearby questions is slightly more
#       complex because questions are mapped to multiple topics
#       and are therefore multi-locational. For this reason, we
#       choose to store questions (1) in the same bucketed location
#       container as the topics and (2) redundantly. Conversely,
#       we might choose to separate storage of topics and questions
#       if this doesn't push memory usage past what is available. This
#       method might deliver slightly improved performance by avoiding the
#       need to either filter all topics or all questions as a form of
#       'bucket preprocessing' when serving queries. We avoid making this
#       modification for now because, in a low-collision environment, it
#       the space-time tradeoff is likely unacceptable.
#   (3) The Python code below is relatively 'loose' and not perfectly
#       optimized for performance. In a production system, we might
#       favor the use of C++ with pointers and contiguously allocated
#       data structures to support a more compact representation. 

import sys

# General Constraints
MAX_INTEGER_ID = 100000

# Location Constants
DEFAULT_GRID_SIDE_LENGTH_EXP = 2.5 # i.e. 10^2.5
GRID_SIDE_LENGTH = math.pow(10,DEFAULT_GRID_SIDE_LENGTH)
NUM_BUCKETS_IN_ROW = math.pow(10,6.0-DEFAULT_GRID_SIDE_LENGTH_EXP)

# Given (x,y) coordinates, returns the index of the corresponding
# location bucket.
def getBucketIndex(x, y):
    return ((y+0.0)/GRID_SIDE_LENGTH)*NUM_BUCKETS_IN_ROW +
    ((x+0.0)/GRID_SIDE_LENGTH)

# Given a 10^6 by 10^6 map, we want to store locations in linearized 
# buckets. We have 10^12 locations and we'll choose a 10^2.5 by 10^2.5
# grid square size so that our container has 10^7 buckets. We're given that
# large problem spaces will map locations uniformly across the covered 
# region so we should expect a low collision rate and, correspondingly, low 
# maximum bucket size. Given a test dataset, the DEFAULT_GRID_SIDE_LENGTH_EXP 
# parameter can optionally be calibrated to determine the size resulting 
# in the lowest collision rate in practice.
locs = []
for i in range(math.pow(10,(12.0-DEFAULT_GRID_SIDE_LENGTH_EXP*2.0))):
    locs.append([])

data = sys.stdin.readlines()
params = data[0].strip().split()
n_topics = params[0]
n_quests = params[1]
n_queries = params[2]

# Stores bucket indexes mapped to topic ids (for use
# in processing questions).
topic_store = []
for i in range(MAX_INTEGER_ID + 1):
    topic_store.append(-1)

# Store topics
for i in range(n_topics):
    entry = data[i+1].strip().split()
    eid = entry[0]
    x = float(entry[1])
    y = float(entry[2])
    index = getBucketIndex(x,y)
    locs[index].append(('t',eid,x,y))
    topic_store[eid] = index

# Store questions
for i in range(n_quests):
    entry = data[i+n_topics+1].strip().split()
    eid = entry[0]
    if int(entry[1]) == 0:
        continue
    for j in range(2,len(entry)):
        bucket_index = topic_store[entry[j]]
        locs[bucket_index].append(('q',eid, entry[j]))

# Handle queries
line = ""
for i in range(n_queries):
    entry = data[i+1+n_topics+n_quests].strip().split()
    code = entry[0]
    num_return = entry[1]
    x = float(entry[2])
    y = float(entry[3])
    index = getBucketIndex(x,y)
    result_tuples = []
    current = [index]
    while len(result_tuples) < num_return: 
        tmp = []
        for index in current:
            for entry in locs[index]:
                if entry[0]==code:
                    tmp.append(entry)

        
