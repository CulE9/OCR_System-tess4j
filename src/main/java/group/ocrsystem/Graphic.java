package group.ocrsystem;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
public class Graphic {

    @Id
    @GeneratedValue
    private Long id;
    private String url;
    private String content;
}
