import styles from './ConfirmDialog.module.css'
import Button from './Button'
import type {Employee} from "./EmployeeList.tsx";

interface Props {
    employee: Employee | null
    onCancel: () => void
    onConfirm: () => void
}

const ConfirmDialog = ({employee, onCancel, onConfirm}: Props) => {
    if (!employee) return null

    const fullName = `${employee.firstName} ${employee.middleName} ${employee.lastName}`
        .replace(/\s+/g, ' ')
        .trim()

    return (
        <div className={styles.modalBackdrop}>
            <div className={`${styles.modal} ${styles.small}`}>
                <h2>Delete Employee</h2>

                <p>
                    Are you sure you want to delete <strong>{fullName}</strong>?
                </p>

                <div className={styles.modalActions}>
                    <Button size="small" onClick={onCancel}>
                        No
                    </Button>

                    <Button size="small" variant="danger" onClick={onConfirm}>
                        Yes
                    </Button>
                </div>
            </div>
        </div>
    )
}

export default ConfirmDialog
