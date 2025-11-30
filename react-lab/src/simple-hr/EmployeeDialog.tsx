import styles from './EmployeeDialog.module.css'
import Button from './Button'
import type {ChangeEvent, FormEvent} from 'react'
import {JOBS} from "./constants.ts";

export interface EmployeeFormData {
    firstName: string
    middleName: string
    lastName: string
    job: string
}

interface Props {
    isOpen: boolean
    mode: 'add' | 'edit'
    formData: EmployeeFormData
    onChange: (event: ChangeEvent<HTMLInputElement | HTMLSelectElement>) => void
    onClose: () => void
    onSubmit: (event: FormEvent<HTMLFormElement>) => void
}

const EmployeeDialog = ({isOpen, mode, formData, onChange, onClose, onSubmit}: Props) => {
    if (!isOpen) return null

    return (
        <div className={styles.modalBackdrop}>
            <div className={styles.modal}>
                <h2>{mode === 'add' ? 'Add Employee' : 'Update Employee'}</h2>

                <form onSubmit={onSubmit} className={styles.modalForm}>
                    <div className={styles.formRow}>
                        <label>First Name</label>
                        <input type="text" name="firstName" value={formData.firstName} onChange={onChange} required/>
                    </div>

                    <div className={styles.formRow}>
                        <label>Middle Name</label>
                        <input type="text" name="middleName" value={formData.middleName ?? ''} onChange={onChange}
                               required/>
                    </div>

                    <div className={styles.formRow}>
                        <label>Last Name</label>
                        <input type="text" name="lastName" value={formData.lastName} onChange={onChange} required/>
                    </div>

                    <div className={styles.formRow}>
                        <label>Job</label>
                        <select name="job" value={formData.job} onChange={onChange}>
                            {JOBS.map((job) => (
                                <option key={job} value={job}>
                                    {job}
                                </option>
                            ))}
                        </select>
                    </div>

                    <div className={styles.modalActions}>
                        <Button size="small" onClick={onClose}>
                            Cancel
                        </Button>
                        <Button size="small" variant="primary" type="submit">
                            {mode === 'add' ? 'Add' : 'Update'}
                        </Button>
                    </div>
                </form>
            </div>
        </div>
    )
}

export default EmployeeDialog
