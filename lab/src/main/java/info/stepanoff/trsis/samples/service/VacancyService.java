/*
 * this code is available under GNU GPL v3
 * https://www.gnu.org/licenses/gpl-3.0.en.html
 */

package info.stepanoff.trsis.samples.service;

import info.stepanoff.trsis.samples.db.model.Vacancy;

public interface VacancyService {

    Iterable<Vacancy> listAll();

    void delete(Integer id);
    
    Vacancy add(Integer number, String name);
    
    Vacancy findByNumber(Integer number);
}
