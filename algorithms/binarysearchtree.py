'''
                  50
        22                 60
    14       35          54        65
  7    19   29  47      51  58    63  69



'''
class Node:

    def __init__(self, id, leftnode, rightnode):
        self.id = id
        self.leftnode = leftnode
        self.rightnode = rightnode


class Tree:

    def __init__(self, nodes, rootnode):
        self.tree = nodes
        self.root = rootnode


sampletreedata =[[50, 22, 60], [22, 14, 35], [60, 54, 65], [14, 7, 19],
            [35, 29, 47], [54, 51, 58], [65, 63, 69], [7, None, None],
            [19, None, None], [29, None, None], [47, None, None],
            [51, None, None], [58, None, None], [63, None, None],
            [69, None, None] ]

sampledata = [7, 14, 50, 19, 60, 35, 63, 58, 22, 65, 54, 69, 47, 29, 51]

'''
Probably a naive approach: find the median and use it as root.
Cut the array in 2 halves at the median, and find median of each half.
Use this as left/right node. recursively repeat this
'''
def buildbinarytree(nodes):
    getmedianindexes(len(nodes))
    return

# TODO 
medianindexes = []
def getmedianindexes(listsize):
    if listsize == 1:
        return
    medianindex = int(round((listsize-1)/2))
    medianindexes.append(medianindex)
    getmedianindexes(medianindex)

# fn to build tree from test data for test validation
def buildsampletreedata(sampletreedata):
    nodes = []
    for samplenode in sampletreedata:
        node = Node(samplenode[0], samplenode[1], samplenode[2])
        nodes.append(node)

    tree = Tree(nodes, sampletreedata[0][0])
    return tree

# buildsampletreedata(sampletreedata)
buildbinarytree(sampledata)
print medianindexes
