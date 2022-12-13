/*
 * this code is available under GNU GPL v3
 * https://www.gnu.org/licenses/gpl-3.0.en.html
 */
package info.stepanoff.sample.kafka;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author Pavel
 */
@Entity
@Table(name = "VACANCY")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Vacancy implements Serializable {

    private static final long serialVersionUID = 1L;

    public Vacancy(Integer nomer, String name) {
        this.number = nomer;
        this.name = name;
    }

    @Id
    @Column(name = "VACANCY_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "VACANCY_NAME")
    private String name;

    @Column(name = "VACANCY_NUMBER", unique = true)
    private Integer number;

}
