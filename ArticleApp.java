
/**
 * ArticleApp.java
 * Kyungjin Cho
 * 17/11/22
 */

// Import Scanner to display menu
import java.util.Scanner;
// Import JoptionPane to display prompt(input&result)
import javax.swing.JOptionPane;

public class ArticleApp {
  public static void main(String[] args) {
    /*
     * Declare and create variables & arrays
     * - Data members: articleTitle, articleWriter, articleComments
     * - The number of items in each array: itemNum
     * - Index of minimum value: minIndex
     * - User's choice: intInput(its value will be choice)
     * - Array of each data member: title, writer, comments
     * - The calculated value of the number of comments: avgComment(average),
     * sumComment(sum)
     */
    String articleTitle, articleWriter;
    int articleComments;
    int itemNum = 0; // The initial number of items: 0 (item was not added yet)
    int choiceNum = 1; // The temporary choice: 1 (prevent 'exit application')
    int minIndex;

    double sumComment, avgComment;

    String title[];
    String writer[];
    int comments[];

    // Connect 'ArticleApp' to instantiable classes
    Article myA = new Article(); // class for managing arrays
    Calculation myC = new Calculation(); // class for finding average & minimum values

    // Declare and create Scanner objects
    Scanner sc = new Scanner(System.in);

    // Display type of items(Online Newspaper Article)
    JOptionPane.showMessageDialog(null,
        "This application is about Online Newspaper Article.\nAttribute: title, journalist, the number of comments.");

    /*
     * - Display application menu(option 1 ~ 6)
     * - Use do-while loop for repetitive prompt(until user enters 6)
     */
    do {
      System.out.println("Application Menu - Item Type: Online Newspaper Ariticle");
      System.out.println("1 - Add an article(title, writer, the number of comments).");
      System.out.println("2 - Display the details of the first entered article.");
      System.out.println("3 - Display the details of the last entered article.");
      System.out.println(
          "4 - Display the average number of comments of all the articles entered until now.");
      System.out.println("5 - Display the article with the smallest number of comments.");
      System.out.println("6 - Exit application.");

      // Ask user to input the choice
      System.out.println("Enter your choice.");

      // Use try-catch statement to prompt user again if user didn't enter number.
      while (true) {
        try {
          choiceNum = sc.nextInt();
          break;
        } catch (Exception e) {
          // Display menu again if user enters invalid number.
          JOptionPane.showMessageDialog(null, "You didn't enter number.\nPlease enter the number between 1 and 6.",
              "Incorrect Input", JOptionPane.ERROR_MESSAGE);
          // Ask user to input the choice again.
          System.out.println("Enter your choice again.");
          sc.next();
          continue;
        }
      }

      // Perform functions according to user's choice
      if (choiceNum == 1) {
        // Prompt user to enter title and writer of each article
        articleTitle = JOptionPane.showInputDialog(null, "Please enter the title of an article.");
        articleWriter = JOptionPane.showInputDialog(null, "Please enter the writer of an article.");

        // Use do-while loop for repetitive prompt(until 0 <= comments <= 15,000)
        do {
          while (true) {
            try {
              articleComments = Integer
                  .parseInt(JOptionPane.showInputDialog(null,
                      "Please enter the number of comments of an article.\nIt should be between 0 and 15,000."));
              break;
            } catch (Exception e) {
              // Display menu again if user enters invalid number.
              JOptionPane.showMessageDialog(null,
                  "You didn't enter number.\nPlease enter the number between 0 and 15,000.",
                  "Incorrect Input", JOptionPane.ERROR_MESSAGE);
              // Ask user to input the choice again.
              continue;
            }
          }

          // Prompt user again if the number of comments is invalid
          if (articleComments < 0 || articleComments > 15000) {
            JOptionPane.showMessageDialog(null, "Please enter the number between 0 and 15,000.", "Incorrect Input",
                JOptionPane.ERROR_MESSAGE);
          }
        } while (articleComments < 0 || articleComments > 15000);

        // itemNum(the number of item in arrays) increased
        itemNum++;

        // Send itemNum to instantiable classes
        myA.setItemNum(itemNum);

        // Send data of each array to Article class
        myA.setArticle(articleTitle, articleWriter, articleComments);

        // Call method for adding attributes to arrays
        myA.computeAdd();

        // Fetch each array from Article class
        title = myA.getTitle();
        writer = myA.getWriter();
        comments = myA.getComments();

        // Send created arrays to instantiable classes
        myA.setArray(title, writer, comments);
        myC.setArray(comments);

      } else if (choiceNum == 2) {
        if (itemNum == 0) {
          // If data was not entered, prompt user to enter details
          JOptionPane.showMessageDialog(null,
              "Please go to the first menu and enter details.\nNo article has been provided.", "No Entered Article",
              JOptionPane.WARNING_MESSAGE);
        } else {
          // Fetch each array from Article class
          title = myA.getTitle();
          writer = myA.getWriter();
          comments = myA.getComments();

          // If data was entered, display details of first item(index = 0)
          JOptionPane.showMessageDialog(null,
              "The details of the first article:\n- Title: " + title[0] + "\n- Writer: " + writer[0]
                  + "\n- The number of comments: " + comments[0],
              "The Details of The First Article", JOptionPane.PLAIN_MESSAGE);
        }

      } else if (choiceNum == 3) {
        if (itemNum == 0) {
          // If data was not entered, prompt user to enter details
          JOptionPane.showMessageDialog(null,
              "Please go to the first menu and enter details.\nNo article has been provided.", "No Entered Article",
              JOptionPane.WARNING_MESSAGE);
        } else {
          // Fetch each array from Article class
          title = myA.getTitle();
          writer = myA.getWriter();
          comments = myA.getComments();

          // If data was entered, display details of last item(index = length - 1)
          JOptionPane.showMessageDialog(null,
              "The details of the last article:\n- Title: " + title[title.length - 1] + "\n- Writer: "
                  + writer[writer.length - 1]
                  + "\n- The number of comments: " + comments[comments.length - 1],
              "The Details of The Last Article", JOptionPane.PLAIN_MESSAGE);
        }

      } else if (choiceNum == 4) {
        if (itemNum == 0) {
          // If data is entered for the first time, it will be added to array
          JOptionPane.showMessageDialog(null,
              "Please go to the first menu and enter details.\nNo article has been provided.", "No Entered Article",
              JOptionPane.WARNING_MESSAGE);
        } else {
          // Call method for calculation average and sum of comments
          myC.computeAvg();

          // Fetch average and sum value from Calculation class
          avgComment = myC.getAvg();
          sumComment = myC.getSum();

          // Fetch comments array from Article class
          comments = myA.getComments();

          /*
           * Display results
           * - The total number of comments / articles
           * - The average number of comments
           */
          JOptionPane.showMessageDialog(null,
              "- The total number of comments\n: " + sumComment + "\n- The total number of articles\n: "
                  + comments.length
                  + "\n- The average number of comments\n: " + avgComment,
              "The Average Number of Comments", JOptionPane.PLAIN_MESSAGE);
        }

      } else if (choiceNum == 5) {

        if (itemNum == 0) {
          // If data is entered for the first time, it will be added to array
          JOptionPane.showMessageDialog(null,
              "Please go to the first menu and enter details.\nNo article has been provided.", "No Entered Article",
              JOptionPane.WARNING_MESSAGE);
        } else {
          // Fetch each array from Article class
          title = myA.getTitle();
          writer = myA.getWriter();
          comments = myA.getComments();

          // Call method for calculating the minimum value
          myC.computeMin();

          // Fetch average and sum value from Calculation class
          minIndex = myC.getMinIndex();

          // Display details of data with the smallest number of comments
          JOptionPane.showMessageDialog(null,
              "The smallest number of comments:\n- Title: " + title[minIndex] + "\n- Writer: "
                  + writer[minIndex] + "\n- The number of comments: " + comments[minIndex],
              "The Smallest Number of Comments", JOptionPane.PLAIN_MESSAGE);
        }

      } else if (choiceNum != 1 && choiceNum != 2 && choiceNum != 3 && choiceNum != 4 && choiceNum != 5
          && choiceNum != 6) {
        // Display menu again if user enters invalid number
        JOptionPane.showMessageDialog(null, "Please enter the number between 1 and 6.", "Incorrect Input",
            JOptionPane.ERROR_MESSAGE);
      }
    } while (choiceNum != 6);

    // Close scanner class
    sc.close();
  }
}
