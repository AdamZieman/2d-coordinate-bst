<h1>Design and Implementation: 2-D BST of Coordinates</h1>
 
 
 
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



<!-- 2D Tree Class -->
<h2>TwoDTree Class</h2>

<h3>Class Variables</h3>
<b>TreeNode root:</b> <i>The root of the 2D tree</i><br>

<h3>Methods</h3>
<b>TwoDTree()</b> <br>
<i>The default constructor initializes an empty TwoDTree.</i> <br><br>

<b>TwoDTree(ArrayList<Point> points)</b> <br>
<i>The parameterized constructor initializes a TwoDTree with a list of points.</i> <br>
 
- Parameters:
  - points: A list of points to be inserted into the TwoDTree.
 
<br>
 
<b>insert(Point point)</b> <br>
<i>Inserts a point into the TwoDTree.</i> <br>
 
- Parameters:
  - point: The point to be inserted into the tree.
 
<br>

<b>search(Point point)</b> <br>
<i>Searches for a point in the tree.</i> <br>
 
- Parameters:
  - point: The point to be searched for in the tree.
- Returns:
  - true if the point is found, false otherwise.
 
<br>
 
<b>searchRange(Point point1, Point point2)</b> <br>
<i>Searches for all points within a given range.</i> <br>
 
- Parameters:
  - point1: One corner of the range.
  - point2: The opposite corner of the range.
- Returns:
  - An ArrayList of all points within the given range.

<br><br>


<!-- Tree Node Class -->
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

<br><br>

<!-- XComparator Class -->
<h2>XComparator Class</h2>

The <b>XComparator</b> class implements the Comparator interface, overrides the compare method, and returns an instance of XComparator.
 
<h3>Class Variables</h3>
<b>XComparator xComparator:</b> <i>Creates an instance of XComparator.</i> <br>

<h3>Methods</h3>
<b>compare(Point point1, Point point2)</b> <br>
<i>Overrides the compare method of the Comparator interface to compare two points based on their x-coordinates.</i> <br>

- Parameters:
  - point1: the first point to compare.
  - point2: the second point to compare.
- Returns:
  - a negative integer, zero, or a positive integer as the first argument is less than, equal to, or greater than the second.

<br>
 
<b>getInstance()</b> <br>
<i>Returns the singleton instance of XComparator.</i> <br>
 
- Returns:
  - the singleton instance of XComparator.

<br><br>

<!-- YComparator Class -->
<h2>YComparator Class</h2>

The <b>XComparator</b> class implements the Comparator interface, overrides the compare method, and returns an instance of YComparator.
 
<h3>Class Variables</h3>
<b>YComparator yComparator:</b> <i>Creates an instance of YComparator.</i> <br>

<h3>Methods</h3>
<b>compare(Point point1, Point point2)</b> <br>
<i>Overrides the compare method of the Comparator interface to compare two points based on their y-coordinates.</i> <br>

- Parameters:
  - point1: the first point to compare.
  - point2: the second point to compare.
- Returns:
  - a negative integer, zero, or a positive integer as the first argument is less than, equal to, or greater than the second.

<br>
 
<b>getInstance()</b> <br>
<i>Returns the singleton instance of YComparator.</i> <br>
 
- Returns:
  - the singleton instance of YComparator.
