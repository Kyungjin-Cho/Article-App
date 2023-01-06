
/**
 * Article.java
 * Kyungjin Cho
 * 17/11/22
 */

public class Article {
  /*
   * Declare and create variables & arrays
   * - Data members: articleTitle, articleWriter, articleComments
   * - The number of items in each array: itemNum
   * - Array of each data member: title, writer, comments
   * - Temporary Array for each array: newTitle, newWriter, newComments
   */
  String articleTitle, articleWriter;
  int articleComments;
  int itemNum; // Its value will be received from ArticleApp

  String title[] = new String[1];
  String writer[] = new String[1];
  int comments[] = new int[1];

  // Declare arrays (it will be created after setting its size)
  String newTitle[];
  String newWriter[];
  int newComments[];

  // Constructor
  public Article() {
  }

  // Compute 'adding an array'
  public void computeAdd() {
    if (itemNum == 1) {
      // If data is entered for the first time, it will be added to array
      title[0] = articleTitle;
      writer[0] = articleWriter;
      comments[0] = articleComments;
    } else {
      /*
       * If data was entered before, temporary arrays are created
       * 1) The size of temporary array is 'size of excisting array + 1'
       * 2) Temporary array has attributes of existing array
       * 3) Newly entered item becomes an attribute of temporary array
       * 4) Temporary array becomes existing array
       */

      // Create temporary array for excisting array named title
      newTitle = new String[title.length + 1];

      // Attributes of title array become arrtirubutes of temporary array
      for (int i = 0; i < title.length; i++) {
        newTitle[i] = title[i];
      }

      // Insert new attribute to temporary array
      newTitle[title.length] = articleTitle;

      // newTitle(temporary array) becomes title(excisting array)
      title = newTitle;

      // Create temporary array for excisting array named writer
      newWriter = new String[writer.length + 1];

      // Attributes of writer array become arrtirubutes of temporary array
      for (int i = 0; i < writer.length; i++) {
        newWriter[i] = writer[i];
      }

      // Insert new attribute to temporary array
      newWriter[writer.length] = articleWriter;

      // newWriter(temporary array) becomes writer(excisting array)
      writer = newWriter;

      // Create temporary array for excisting array named comments
      newComments = new int[comments.length + 1];

      // Attributes of comments array become arrtirubutes of temporary array
      for (int i = 0; i < comments.length; i++) {
        newComments[i] = comments[i];
      }

      // Insert new attribute to temporary array
      newComments[comments.length] = articleComments;

      // newComments(temporary array) becomes comments(excisting array)
      comments = newComments;
    }
  };

  // Receive newly entered attributes of each array from ArticleApp
  public void setArticle(String articleTitle, String articleWriter, int articleComments) {
    this.articleTitle = articleTitle;
    this.articleWriter = articleWriter;
    this.articleComments = articleComments;
  }

  // Receive each existing array from ArticleApp
  public void setArray(String[] title, String[] writer, int[] comments) {
    this.title = title;
    this.writer = writer;
    this.comments = comments;
  }

  // Receive the number of items from ArticleApp
  public void setItemNum(int itemNum) {
    this.itemNum = itemNum;
  }

  // Return updated arrays after adding new attributes
  public String[] getTitle() {
    return title;
  };

  public String[] getWriter() {
    return writer;
  };

  public int[] getComments() {
    return comments;
  };
}
