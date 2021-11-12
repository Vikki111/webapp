package com.example.app.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "employee_operation")
@Data
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
//@SqlResultSetMapping(
//        name="empOperation",
//        classes={
//                @ConstructorResult(
//                        targetClass=EmployeeOperation.class,
//                        columns={
//                                @ColumnResult(name="orderNumber"),
//                                @ColumnResult(name="dateOperation"),
//                                @ColumnResult(name="regNumber"),
//                                @ColumnResult(name="positionId"),
//                                @ColumnResult(name="typeOperationId"),
//                                @ColumnResult(name="departmentId"),
//                                @ColumnResult(name="departmentName")
//                        }
//                )
//        }
//)
public class EmployeeOperation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_number")
    private Integer orderNumber;
    @Column(name = "date_operation")
    private Date dateOperation;
    @Column(name = "reg_number")
    private Integer regNumber;
    @Column(name = "position_id")
    private Integer positionId;
    @Column(name = "type_operation_id")
    private Integer typeOperationId;
    @Column(name = "department_id")
    private Integer departmentId;

    @Transient
    private String lastName;
    @Transient
    private String positionName;
    @Transient
    private String typeOperationName;
    @Transient
    private String departmentName;


}
