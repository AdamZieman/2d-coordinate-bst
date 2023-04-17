package TwoDSearchTree;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Comparator;

/**
 * A 2D Tree is a data structure that can be used to store and search for points in two-dimensional space.
 * It is a binary tree that partitions the points based on their coordinates.
 * @author Adam Zieman
 */
public class TwoDTree {
    TreeNode root; // the root of the 2D tree

    /**
     * Default constructor: initializes an empty 2D Tree.
     */
    public TwoDTree() {
        root = null;
    }

    /**
     * Parameterized constructor: initializes an empty 2D Tree.
     * @param points A list of points to be inserted into the 2D Tree.
     */
    public TwoDTree(ArrayList<Point> points) {
        // For each point in the list of points, the insert method is called to add it to the TwoDTree
        for (Point point : points) {
            insert(point);
        }
    }

    /**
     * Inserts a point into the 2D Tree.
     * @param point The point to be inserted.
     */
    public void insert(Point point) {
        // If the root node is null, create a new root node with the given point
        if (root == null) {
            root = new TreeNode(point, YComparator.getInstance(), XComparator.getInstance());
        }
        // Otherwise, call the insert method to insert of the root node
        else {
            root.insert(point);
        }
    }

    /**
     * Searches for a point in the 2D Tree.
     * @param point The point to be searched for.
     * @return True if the point is found, false otherwise.
     */
    public boolean search(Point point) {
        // If the root node is null, return false
        if (root == null) {
            return false;
        }
        // Otherwise, call the search method of the root node
        else {
            return root.search(point);
        }
    }

    /**
     * Searches for all points within a given range.
     * @param point1 One corner of the range.
     * @param point2 The opposite corner of the range.
     * @return A list of all points within the given range.
     */
    public ArrayList<Point> searchRange(Point point1, Point point2) {
        return root.searchRange(point1, point2);
    }

    /**
     * The TreeNode class represents a node in the 2D Tree.
     */
    class TreeNode {
        Point point; // the point stored in this object
        TreeNode leftSubtree; // the left subtree
        TreeNode rightSubtree; // the right subtree
        Comparator<Point> currentLevelComparator; // a comparator to make decisions on this level
        Comparator<Point> childLevelComparator; // a comparator to make decisions on the child level

        /**
         * Initializes a new TreeNode with the given point and comparators.
         * @param point The point to be stored in the node.
         * @param meComp The comparator used to make decisions on this level.
         * @param childComp The comparator used to make decisions on the child level.
         */
        public TreeNode(Point point, Comparator<Point> meComp, Comparator<Point> childComp) {
            this.point = point;
            this.currentLevelComparator = meComp;
            this.childLevelComparator = childComp;
        }

        /**
         * Inserts a point into the subtree rooted at this node.
         * @param point The point to be inserted.
         */
        public void insert(Point point) {
            /*
            If the point to insert is less than or equal to the current node's point, insert the point in the
            left subtree
             */
            if (currentLevelComparator.compare(this.point, point) >= 0) {
                // If a left subtree exists, recursively insert into the left subtree
                if (leftSubtree != null) {
                    leftSubtree.insert(point);
                }
                // Otherwise, create a left subtree with the given point
                else {
                    leftSubtree = new TreeNode(point, childLevelComparator, currentLevelComparator);
                }
            }
            // Otherwise, insert the point in the right subtree
            else if (currentLevelComparator.compare(this.point, point) < 0) {
                // If a right subtree exists, recursively insert into the right subtree
                if (rightSubtree != null) {
                    rightSubtree.insert(point);
                }
                // Otherwise, create a new one with the given point
                else {
                    rightSubtree = new TreeNode(point, childLevelComparator, currentLevelComparator);
                }
            }
        }

        /**
         * Searches for a point in the K-D Tree.
         * @param point the point to search for
         * @return true if the point is found, false otherwise
         */
        public boolean search(Point point) {
            // Check if the current node is the target point
            if (currentLevelComparator.compare(this.point, point) == 0 &&
                    childLevelComparator.compare(this.point, point) == 0) {
                return true;
            }

            // Traverse the left subtree if the target point is to the left of the current node
            if (currentLevelComparator.compare(this.point, point) >= 0 &&
                    leftSubtree != null) {
                return leftSubtree.search(point);
            }
            // Traverse the right subtree if the target point is to the right of the current node
            else if (currentLevelComparator.compare(this.point, point) < 0 &&
                    rightSubtree != null) {
                return rightSubtree.search(point);
            }
            // Target point not found in the tree
            else {
                return false;
            }
        }

        /**
         * Searches for points within a given range in the K-D Tree.
         * @param point1 the first point defining the search range
         * @param point2 the second point defining the search range
         * @return an ArrayList of points within the search range
         */
        public ArrayList<Point> searchRange(Point point1, Point point2) {
            // Find the lower left and upper right points of the search range
            Point lowerLeft = new Point(Math.min(point1.x, point2.x), Math.min(point1.y, point2.y));
            Point upperRight = new Point(Math.max(point1.x, point2.x), Math.max(point1.y, point2.y));

            // Create an ArrayList to store the points found within the search range
            ArrayList<Point> results = new ArrayList<>();

            // Search for all points within the search range and add them to the results ArrayList
            searchRange(lowerLeft, upperRight, results);

            return results; // Return the results ArrayList
        }

        /**
         * Helper method for recursively searching for points within a given range in the K-D Tree.
         * @param lowerLeft the lower left point defining the search range
         * @param upperRight the upper right point defining the search range
         * @param results the ArrayList to add the points found within the search range
         * @return the ArrayList of points within the search range
         */
        private ArrayList<Point> searchRange(Point lowerLeft, Point upperRight, ArrayList<Point> results) {
            // Check if the current point is within the specified range
            if (this.point.x >= lowerLeft.x && this.point.x <= upperRight.x &&
                    this.point.y >= lowerLeft.y && this.point.y <= upperRight.y) {
                results.add(this.point);
            }

            // Check if the left subtree could contain points within the range
            if (this.currentLevelComparator.compare(point, lowerLeft) >= 0 && leftSubtree != null) {
                leftSubtree.searchRange(lowerLeft, upperRight, results);
            }

            // Check if the right subtree could contain points within the range
            if (this.currentLevelComparator.compare(point, upperRight) <= 0 && rightSubtree != null) {
                rightSubtree.searchRange(lowerLeft, upperRight, results);
            }

            return results; // Return the results ArrayList
        }
    }
}

/**
 * A comparator for comparing points based on their x-coordinates.
 */
class XComparator implements Comparator<Point> {
    public static XComparator xComparator = new XComparator(); // An instance of XComparator

    /**
     * Overrides the compare method of the Comparator interface to compare two points based on their x-coordinates.
     * @param point1 the first point to compare
     * @param point2 the second point to compare
     * @return a negative integer, zero, or a positive integer as the first argument is less than, equal to,
     * or greater than the second.
     */
    @Override
    public int compare(Point point1, Point point2) {
        return point1.x - point2.x;
    }

    /**
     * Returns the singleton instance of XComparator.
     * @return the singleton instance of XComparator
     */
    public static XComparator getInstance() {
        return xComparator;
    }
}

/**
 * A comparator for comparing points based on their y-coordinates.
 */
class YComparator implements Comparator<Point> {
    public static YComparator yComparator = new YComparator(); // An instance of YComparator

    /**
     * Overrides the compare method of the Comparator interface to compare two points based on their y-coordinates.
     * @param point1 the first point to compare
     * @param point2 the second point to compare
     * @return a negative integer, zero, or a positive integer as the first argument is less than, equal to,
     * or greater than the second.
     */
    @Override
    public int compare(Point point1, Point point2) {
        return point1.y - point2.y;
    }

    /**
     * Returns the singleton instance of YComparator.
     * @return the singleton instance of YComparator
     */
    public static YComparator getInstance() {
        return yComparator;
    }
}
