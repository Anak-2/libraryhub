package se.libraryhub.hashtag.domain;

import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import se.libraryhub.library.domain.Library;
import se.libraryhub.project.domain.Project;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Hashtag {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "project_id")
    private Project project;

    @ManyToOne
    @JoinColumn(name = "library_id")
    private Library library;

    private String content;

    @Builder
    public Hashtag(Project project, String content){
        this.project = project;
        this.content = content;
        this.library = null;
    }

    @Builder
    public Hashtag(Library library, String content){
        this.library = library;
        this.content = content;
        this.project = null;
    }
}