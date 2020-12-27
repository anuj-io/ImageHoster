package ImageHoster.controller;

import ImageHoster.model.Comment;
import ImageHoster.model.Image;
import ImageHoster.model.User;
import ImageHoster.service.CommentService;
import ImageHoster.service.ImageService;
import java.time.LocalDate;
import java.util.Date;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CommentController {

  @Autowired
  private CommentService commentService;

  @Autowired
  private ImageService imageService;

  // The controller method is called to post a comment against a given image id.
  // Redirects to same image route which would render the page with same comment.
  @RequestMapping(value = "/image/{imageId}/{imageTitle}/comments", method = RequestMethod.POST)
  public String registerComment(@PathVariable("imageId") int imageId, @PathVariable("imageTitle") String imageTitle, @RequestParam("comment") String commentText, Comment comment, HttpSession session) {
    User user = (User) session.getAttribute("loggeduser");
    Image image = imageService.getImage(imageId);

    comment.setCreatedDate(LocalDate.now());
    comment.setImage(image);
    comment.setUser(user);
    comment.setText(commentText);

    commentService.registerComment(comment);

    return "redirect:/images/" + imageId + "/" + imageTitle;
  }

}
