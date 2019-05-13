package dto;

import javax.persistence.*;

@Entity()
@Table(name = "collections")
@Access(AccessType.FIELD)
public class CollectionDTO extends AbstractDTO {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @OneToOne
    @JoinColumn(name = "movie_id", referencedColumnName = "id")
    private MovieDTO movie;

    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private UserDTO user;

    @Override
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public MovieDTO getMovie() {
        return movie;
    }

    public void setMovie(MovieDTO movie) {
        this.movie = movie;
    }

    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }
}
