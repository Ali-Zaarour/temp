import styles from './EmployeeList.module.css'
import Button from './Button'

export interface Employee {
    id: number;
    firstName: string;
    middleName: string;
    lastName: string;
    job: string;
}

interface Props {
    employees: Employee[];
    onEdit: (employee: Employee) => void;
    onDelete: (employee: Employee) => void;
}

const EmployeeList = ({employees, onEdit, onDelete}: Props) => {
    return (
        <>
            <div className={styles.listHeader}>
                <span>Full Name</span>
                <span className={styles.listHeaderJob}>Job</span>
                <span className={styles.listHeaderActions}>Actions</span>
            </div>

            <div className={styles.employeeList}>
                {employees.length === 0 && (
                    <div className={styles.emptyState}>No employees found.</div>
                )}

                {employees.map((employee) => {
                    const fullName = `${employee.firstName} ${employee.middleName ?? ''} ${employee.lastName}`
                        .replace(/\s+/g, ' ')
                        .trim()

                    return (
                        <div key={employee.id} className={styles.employeeRow}>
                            <span className={styles.employeeName}>{fullName}</span>
                            <span className={styles.employeeJob}>{employee.job}</span>
                            <div className={styles.employeeActions}>
                                <Button
                                    size="small"
                                    onClick={() => onEdit(employee)}
                                >
                                    Edit
                                </Button>
                                <Button
                                    size="small"
                                    variant="danger"
                                    onClick={() => onDelete(employee)}
                                >
                                    Delete
                                </Button>
                            </div>
                        </div>
                    )
                })}
            </div>
        </>
    )
}

export default EmployeeList
