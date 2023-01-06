
/**
 * Calculation.java
 * Kyungjin Cho
 * 17/11/22
 */

public class Calculation {
  /*
   * Declare and create variables & arrays
   * - The number of comments: comments
   * - Index of minimum value: minIndex
   * - The calculated value of the number of comments: avgComment(average),
   * sumComment(sum)
   */
  int comments[];

  int minIndex;
  double avgComment, sumComment;

  // Constructor
  public Calculation() {
  }

  // Compute 'Calculating the average value'
  public void computeAvg() {
    // Calculate the total number of comments using for loop
    for (int i = 0; i < comments.length; i++) {
      sumComment += comments[i];
    }
    // Calculate the average number of comments
    avgComment = sumComment / comments.length;
  }

  // Compute 'Calculating the minimum value'
  public void computeMin() {
    // If data was entered, find the index of minimum value using for loop
    minIndex = 0; // Temporary index value is 0

    // Do for loop from index 1 because initial index of minimum value is 0
    for (int i = 1; i < comments.length; i++) {
      if (comments[i] < comments[minIndex]) {
        minIndex = i;
      }
    }
  }

  // Receive each existing array from ArticleApp
  public void setArray(int[] comments) {
    this.comments = comments;
  }

  // Return average and sum
  public double getAvg() {
    return avgComment;
  }

  public double getSum() {
    return sumComment;
  }

  // Return index of attributes with the smalles number of comments
  public int getMinIndex() {
    return minIndex;
  }
}
