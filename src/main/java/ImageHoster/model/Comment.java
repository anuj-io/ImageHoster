package ImageHoster.model;

import java.time.LocalDate;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

//@Entity annotation specifies that the corresponding class is a JPA entity
@Entity
//@Table annotation provides more options to customize the mapping.
//Here the name of the table to be created in the database is explicitly mentioned as 'users'. Hence the table named 'users' will be created in the database with all the columns mapped to all the attributes in 'User' class
@Table(name = "comment")
public class Comment {
  //@Id annotation specifies that the corresponding attribute is a primary key
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  //@Column annotation specifies that the attribute will be mapped to the column in the database.
  //Here the column name is explicitly mentioned as 'id'
  @Column(name = "id")
  private Integer id;

  @Column(name = "text")
  private String text;

  @Column(name = "createdDate")
  private LocalDate createdDate;

  @ManyToOne(fetch = FetchType.EAGER)
  //Below annotation indicates that the name of the column in 'images' table referring the primary key in 'users' table will be 'user_id'
  @JoinColumn(name = "user_id")
  private User user;

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "image_id")
  private Image image;

  public Comment() {

  }

  public Comment (int id, String text, LocalDate date) {
    this.id = id;
    this.text = text;
    this.createdDate = date;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }

  public LocalDate getCreatedDate() {
    return createdDate;
  }

  public void setCreatedDate(LocalDate createdDate) {
    this.createdDate = createdDate;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  public Image getImage() {
    return image;
  }

  public void setImage(Image image) {
    this.image = image;
  }

}

