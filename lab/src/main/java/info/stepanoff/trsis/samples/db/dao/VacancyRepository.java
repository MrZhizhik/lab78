/*
 * this code is available under GNU GPL v3
 * https://www.gnu.org/licenses/gpl-3.0.en.html
 */
package info.stepanoff.trsis.samples.db.dao;

import info.stepanoff.trsis.samples.db.model.Vacancy;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Pavel
 */
public interface VacancyRepository extends CrudRepository<Vacancy, Integer> {

    Vacancy findByNumber(Integer number);
}
