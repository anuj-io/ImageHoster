package ImageHoster.repository;

import ImageHoster.model.Comment;
import ImageHoster.model.Image;
import java.util.List;
import org.springframework.stereotype.Repository;

import javax.persistence.*;

@Repository
public class CommentRepository {

  @PersistenceUnit(unitName = "imageHoster")
  private EntityManagerFactory emf;

  //The method receives the Comment object to be persisted in the database
  //Creates an instance of EntityManager
  //Starts a transaction
  //The transaction is committed if it is successful
  //The transaction is rolled back in case of unsuccessful transaction
  public void registerComment(Comment newComment) {
    EntityManager em = emf.createEntityManager();
    EntityTransaction transaction = em.getTransaction();

    try {
      transaction.begin();
      em.persist(newComment);
      transaction.commit();
    } catch (Exception e) {
      transaction.rollback();
    }
  }

  //The method creates an instance of EntityManager
  //Executes JPQL query to fetch all the comments for given image id from the database
  //Returns the list of all the comments fetched from the database
  public List<Comment> getAllComments(int imageId) {
    EntityManager em = emf.createEntityManager();
    TypedQuery<Comment> query = em.createQuery("SELECT c from Comment c where c.image.id =:imageId", Comment.class).setParameter("imageId", imageId);;
    List<Comment> resultList = query.getResultList();

    return resultList;
  }
}
