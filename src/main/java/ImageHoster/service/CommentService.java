package ImageHoster.service;

import ImageHoster.model.Comment;
import ImageHoster.repository.CommentRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentService {
  @Autowired
  private CommentRepository commentRepository;

  // Get list of all the comments for the given image id in the repository
  public List<Comment> getAllComments(int imageId) { return commentRepository.getAllComments(imageId);}

  // Register the comment in DB
  public void registerComment(Comment comment) { commentRepository.registerComment(comment);}

}
