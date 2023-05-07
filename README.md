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



<!-- Tree Node -->
<h2>Tree Node (Inner-Class)</h2>

The <b>TreeNode</b> class represents a node in the TwoDTree.

<h3>Class Variables</h3>
<b>Point point:</b> <i>The point stored in this object.</i> <br>
<b>TreeNode leftSubtree:</b> <i>The left subtree.</i> <br>
<b>TreeNode rightSubtree:</b> <i>The right subtree.</i> <br>
<b>Comparator<Point> currentLevelComparator:</b> <i>A comparator to make decisions on this level.</i> <br>
 <b>Comparator<Point> childLevelComparator:</b> <i>A comparator to make decisions on the child level.</i> <br>

<h3>Methods</h3>
<b>TreeNode(Point point, Comparator<Point> meComp, Comparator<Point> childComp)</b> <br>
<i>Constructs a new TreeNode with the given point and comparators.</i> <br>
 
- Parameters:
  - point: The point to be stored in the node.
  - meComp: The comparator used to make decisions on this level.
  - childComp: The comparator used to make decisions on the child level.
 
 <br>
 
<b>insert(Point point)</b> <br>
 <i>Inserts a point into the subtree, rooted at this node.</i> <br>
 
- Parameters:
  - point: The point to be inserted.
 
<br>
 
<b>search(Point point)</b> <br>
<i>Search for a point in the tree.</i> <br>

- Parameters:
  - point: The point to be inserted.
- Returns:
  - true if the point is found, false otherwise.
 
<br>
 
<b>searchRange(Point point1, Point point2)</b> <br>
<i>Search for the points within a given range of the tree.</i> <br>

- Parameters:
  - point1: The first point defining the search range.
  - point2: The second point defining the search range.
- Returns:
  - An ArrayList of Points within the search range.
 
<br>
 
<b>searchRange(Point lowerLeft, Point upperRight, ArrayList<Point> results)</b> <br>
<i>Helper method for recursively searching for points within a given range in the tree.</i> <br>
 
- Parameters:
  - lowerLeft: The lower left point defining the search range.
  - upperRight: The upper right point defining the search range.
  - results: The ArrayList of Points to add the POints found within the search range.
- Returns:
  - An ArrayList of Points within the search range.
