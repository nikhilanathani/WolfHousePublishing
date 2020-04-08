package services;

import constants.Constants;
import entity.Book;
import entity.Publication;
import entity.PublicationTopic;
import utility.DatabaseUtility;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class BookService {

    private static final String GET_ALL_BOOKS = "SELECT B.PUBLICATION_ID AS ID, B.ISBN_NO AS ISBN, B.EDITION AS EDITION, P.TITLE AS TITLE, P.PUBLICATION_DATE AS PUB_DATE, P.PRICE AS PRICE , P.PUBLICATION_TOPIC AS TOPIC_ID, PT.NAME AS TOPIC FROM BOOKS B, PUBLICATION P, PUBLICATION_TOPIC PT WHERE B.PUBLICATION_ID = P.ID AND P.PUBLICATION_TOPIC = PT.ID" ;

    private static final String GET_BOOKS_BY_TOPIC = "SELECT B.PUBLICATION_ID AS PUB_ID, B.ISBN_NO AS ISBN, B.EDITION AS EDITION," +
            " P.TITLE AS TITLE, P.PUBLICATION_DATE AS PUBLICATION_DATE, P.PRICE AS PRICE, " +
            "PT.ID AS TOPIC_ID, PT.NAME AS TOPIC " +
            "FROM BOOKS B, PUBLICATION P, PUBLICATION_TOPIC PT " +
            "WHERE B.PUBLICATION_ID = P.ID AND P.PUBLICATION_TOPIC = PT.ID AND PT.NAME =?";

    private static final String GET_BOOKS_BY_DATE = "SELECT B.ISBN_NO, B.EDITION, " +
            "P1.ID AS PUB_ID, P1.TITLE AS TITLE, P1.PUBLICATION_DATE AS PUBLICATION_DATE, P1.PRICE AS PRICE, " +
            "P2.ID AS TOPIC_ID, P2.NAME AS TOPIC " +
            "FROM BOOKS B, PUBLICATION P1, PUBLICATION_TOPIC P2 " +
            "WHERE P1.PUBLICATION_TOPIC = P2.ID AND P1.PUBLICATION_DATE = ?";

    public List<Object> getAllBooks(){

        List<Object> books = new ArrayList<>();
        Connection connection = null;

        try{
            connection = DatabaseUtility.getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL_BOOKS);

            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet!=null){
                while(resultSet.next()){
                    PublicationTopic publicationTopic = new PublicationTopic(resultSet.getInt("TOPIC_ID"), resultSet.getString("TOPIC"));
                    Publication publication = new Publication(resultSet.getInt("ID"), resultSet.getString("TITLE"),resultSet.getDate("PUB_DATE"),
                            resultSet.getInt("PRICE"), publicationTopic);
                    Book book = new Book(publication, resultSet.getInt("ISBN"), resultSet.getString("EDITION"));
                    books.add(book);
                }
            }

        } catch(Exception e){
            System.out.println(Constants.CONNECTION_ERROR.getMessage());
            return books;
        } finally {
            try{
                DatabaseUtility.closeconnection();
            } catch (Exception e){
                System.out.println(Constants.CONNECTION_CLOSE_ERROR.getMessage());
            }
            return books;
        }
    }

    public List<Object> getBookByTopic(String topic){
        List<Object> books = new ArrayList<>();
        Connection connection = null;
        try{
            connection = DatabaseUtility.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(GET_BOOKS_BY_TOPIC);
            preparedStatement.setString(1,topic);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet!=null){
                while(resultSet.next()){
                    books.add(new Book(new Publication(resultSet.getInt("PUB_ID"),resultSet.getString("TITLE"),
                            resultSet.getDate("PUBLICATION_DATE"),resultSet.getInt("PRICE"),
                            new PublicationTopic(resultSet.getInt("TOPIC_ID"),resultSet.getString("TOPIC"))),
                            resultSet.getInt("ISBN_NO"),resultSet.getString("EDITION")));
                }
            }
        }catch(Exception e){
            System.out.println(Constants.CONNECTION_ERROR.getMessage());
            return books;
        }finally {
            try{
                DatabaseUtility.closeconnection();
            }catch(Exception e){
                System.out.println(Constants.CONNECTION_CLOSE_ERROR.getMessage());
            }
            return books;
        }
    }


    public List<Object> getBookSByDate(String date){
        List<Object> books = new ArrayList<>();
        Connection connection = null;
        try{
            connection = DatabaseUtility.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(GET_BOOKS_BY_DATE);
            preparedStatement.setDate(1, Date.valueOf(date));
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet!=null){
                while(resultSet.next()){
                    books.add(new Book(new Publication(resultSet.getInt("PUB_ID"),resultSet.getString("TITLE"),
                            resultSet.getDate("PUBLICATION_DATE"),resultSet.getInt("PRICE"),
                            new PublicationTopic(resultSet.getInt("TOPIC_ID"),resultSet.getString("TOPIC"))),
                            resultSet.getInt("ISBN_NO"),resultSet.getString("EDITION")));
                }
            }
        }catch(Exception e){
            System.out.println(Constants.CONNECTION_ERROR.getMessage());
            return books;
        }finally {
            try{
                DatabaseUtility.closeconnection();
            }catch(Exception e){
                System.out.println(Constants.CONNECTION_CLOSE_ERROR.getMessage());
            }
            return books;
        }
    }

    public List<Object> getBookByDate(){
        return null;
    }

}
