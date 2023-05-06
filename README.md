<h1>Design and Implementation of a 2D Coordinate BST</h1>
 
 
 
<!-- Program Description -->
A data structure that enables the storage and search of points in two-dimensional space. It is implemeneted as a binary tree, where the nodes are partitioned based on their coordinates. The partitioning is done based on a comparator that alternates between comparing the x- and y-coordinates of the points on each level.

<br>



<!-- Getting Started -->
<h2>Getting Started</h2>
To use the Coordinate Tree class in your own code, follow these steps:
<br><br>

1. Clone the project from GitHub.
2. Import the Coordinate Tree package.
3. Create a new instance of the Coordinate Tree class.
4. Insert points into the tree using the 'insert' method.
5. Search for points using the 'search' method.
6. Search for points within a range using the 'searchRange' method.

<br>



<!-- Tree Node Attributes -->
<h2>Tree Node Attributes</h2>

The <b>TreeNode</b> class represents a node in the TwoDTree.

<h3>TreeNode(Point point, Comparator<Point> meComp, Comparator<Point> childComp)</h3>

- Initializes a new TreeNode with the given point and comparators.
- Parameters:
  - point: The point to be stored in the node.
  - meComp: The comparator used to make decisions on this level.
  - childComp: The comparator used to make decisions on the child level.
