package com.example.app.repository;

import com.example.app.model.EmployeeOperation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.SqlResultSetMapping;
import java.util.List;

public interface EmployeeOperationRepository extends JpaRepository<EmployeeOperation, Integer> {

//    @Query(
//            value = "SELECT\n" +
//                    "  eo.order_number as orderNumber,\n" +
//                    "  eo.date_operation as dateOperation,\n" +
//                    "  eo.reg_number as regNumber,\n" +
//                    "  eo.position_id as positionId,\n" +
//                    "  eo.department_id as departmentId,\n" +
//                    "  d.department_name as departmentName\n" +
//                    "FROM\n" +
//                    "  employee_operation as eo\n" +
//                    "  INNER JOIN department as d\n" +
//                    "    ON eo.department_id = d.department_id\n" +
//                    "WHERE\n" +
//                    "  order_number = 1",
//            nativeQuery = true, name = "empOperation")
//    EmployeeOperation findOneEmployeeOperation();

//    @Query("SELECT new com.example.app.model.EmployeeOperation(eo.order_number, eo.date_operation, eo.reg_number, eo.position_id, eo.department_id, d.department_name) " +
//            "FROM\n" +
//            "  employee_operation as eo\n" +
//            "  INNER JOIN department as d\n" +
//            "    ON eo.department_id = d.department_id\n" +
//            "WHERE\n" +
//            "  order_number = 1")
//    EmployeeOperation findOneEmployeeOperation();
}
