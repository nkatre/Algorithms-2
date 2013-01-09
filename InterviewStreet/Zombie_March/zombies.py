# Solver for the Zombie March InterviewStreet Challenge
# 
# @date: 	12.23.2012
# @author:	Sanjay Paul
import sys

#data = sys.stdin.readlines()
data = open('input00.txt').readlines()
data = map(lambda s: s.strip(), data)
print len(data)
iters = int(data.pop(0))

for i in xrange(iters):

    # Parse adjacency matrix and initial positions
    arr = data.pop(0).split()
    nodes = int(arr[0])
    edges = int(arr[1])
    steps = int(arr[2])
    adjmat = [[0.0 for i in range(nodes)] for j in range(nodes)]
    for j in xrange(edges):
        edge = data.pop(0).split()
        u = int(edge[0])
        j = int(edge[1])
        adjmat[u][j] = 1.0
        adjmat[j][u] = 1.0
    vect = [0.0 for i in range(nodes)]
    for j in xrange(nodes):
        vect[j]=int(data.pop(0))

    # Convert to stochastic matrix
    for row in adjmat:
        total = sum(row)
        for i in xrange(len(row)):
            row[i] /= total
    
    # Execute Markov process for k iterations
    for k in xrange(steps):
        next = [0.0 for i in range(nodes)]
        for index in xrange(nodes):
            next[index] = sum([i*j for i,j in zip([row[index] for row in adjmat],vect)])
        vect = next
    
    # Format results and output
    rounded = []
    for i in xrange(len(vect)):
        rounded.append(int(round(vect[i],0)))
    rounded = sorted(rounded)[-5:]
    for i in reversed(rounded):
        print i,
    print
