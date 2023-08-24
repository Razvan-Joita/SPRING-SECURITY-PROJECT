//package org.nexttech.repos.interfaces;
//
//import org.nexttech.repos.entity.Student;
//
//import java.util.List;
//
///**
// * An interface extending the {@link CrudRepository} for managing {@link Student} entities.
// * Provides additional methods for querying and managing student information.
// */
//public interface IStudentRepository extends CrudRepository<Integer, Student> {
//
//    /**
//     * Retrieves a list of students filtered by their first name or last name,
//     * based on the provided filter text.
//     *
//     * @param filterText The text to filter students' first names or last names.
//     * @return A list of students matching the filtering criteria.
//     */
//    List<Student> filterByFirstNameOrByLastName(String filterText, int page, int pageSize);
//
//    /**
//     * Checks whether a given CNP (Personal Numeric Code) is unique within the repository.
//     *
//     * @param cnp The CNP to check for uniqueness.
//     * @return {@code true} if the CNP is unique, {@code false} otherwise.
//     */
//    Boolean isUniqueCNP(Long cnp);
//
//    /**
//     * Retrieves a list of all students stored in the repository.
//     *
//     * @return A list of all students.
//     */
//    List<Student> getAllStudents(int page, int pageSize);
//
//
//
//}
