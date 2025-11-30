import {useMemo, useState, type ChangeEvent, type FormEvent} from 'react'
import styles from './SimpleHr.module.css'
import Button from './Button'
import SearchBar from './SearchBar'
import EmployeeList, {type Employee} from './EmployeeList'
import Pagination from './Pagination'
import EmployeeDialog, {type EmployeeFormData} from './EmployeeDialog'
import ConfirmDialog from './ConfirmDialog'
import {INITIAL_EMPLOYEES} from './constants'

const ITEMS_PER_PAGE = 10

type DialogMode = 'add' | 'edit'

const SimpleHr = () => {

    const [employees, setEmployees] = useState(INITIAL_EMPLOYEES)
    const [searchTerm, setSearchTerm] = useState('')
    const [currentPage, setCurrentPage] = useState(1)

    const [isDialogOpen, setIsDialogOpen] = useState(false)
    const [dialogMode, setDialogMode] = useState<DialogMode>('add')
    const [editingEmployeeId, setEditingEmployeeId] = useState<number | null>(null)

    const [formData, setFormData] = useState<EmployeeFormData>({
        firstName: '',
        middleName: '',
        lastName: '',
        job: '',
    })

    const [deleteConfirmEmployee, setDeleteConfirmEmployee] = useState<Employee | null>(null)

    const filteredEmployees = useMemo(() => {
        const term = searchTerm.trim().toLowerCase()
        if (!term) return employees

        return employees.filter((emp) => {
            const fullName = `${emp.firstName} ${emp.middleName ?? ''} ${emp.lastName}`
            return fullName.toLowerCase().includes(term)
        })
    }, [employees, searchTerm])

    const totalPages = Math.max(1, Math.ceil(filteredEmployees.length / ITEMS_PER_PAGE))

    const paginatedEmployees = useMemo(() => {
        const startIndex = (currentPage - 1) * ITEMS_PER_PAGE
        return filteredEmployees.slice(startIndex, startIndex + ITEMS_PER_PAGE)
    }, [filteredEmployees, currentPage])

    const handleOpenAddDialog = () => {
        setDialogMode('add')
        setEditingEmployeeId(null)
        setFormData({
            firstName: '',
            middleName: '',
            lastName: '',
            job: '',
        })
        setIsDialogOpen(true)
    }

    const handleOpenEditDialog = (employee: Employee) => {
        setDialogMode('edit')
        setEditingEmployeeId(employee.id)
        setFormData({
            firstName: employee.firstName,
            middleName: employee.middleName,
            lastName: employee.lastName,
            job: employee.job,
        })
        setIsDialogOpen(true)
    }

    const handleDialogClose = () => {
        setIsDialogOpen(false)
    }

    const handleFormChange = (
        e: ChangeEvent<HTMLInputElement | HTMLSelectElement>,
    ) => {
        const {name, value} = e.target
        setFormData((prev) => ({
            ...prev,
            [name]: value,
        }))
    }

    const handleDialogSubmit = (e: FormEvent<HTMLFormElement>) => {
        e.preventDefault()

        if (!formData.firstName.trim() || !formData.lastName.trim()) {
            alert('First name and last name are required.')
            return
        }

        if (dialogMode === 'add') {
            const nextId =
                employees.length > 0 ? Math.max(...employees.map((e) => e.id)) + 1 : 1

            const newEmployee: Employee = {
                id: nextId,
                firstName: formData.firstName.trim(),
                middleName: formData.middleName?.trim(),
                lastName: formData.lastName.trim(),
                job: formData.job,
            }

            setEmployees((prev) => [...prev, newEmployee])

            const newTotal = employees.length + 1
            const newTotalPages = Math.ceil(newTotal / ITEMS_PER_PAGE)
            setCurrentPage(newTotalPages)
        } else if (dialogMode === 'edit' && editingEmployeeId != null) {
            setEmployees((prev) =>
                prev.map((emp) =>
                    emp.id === editingEmployeeId
                        ? {
                            ...emp,
                            firstName: formData.firstName.trim(),
                            middleName: formData.middleName?.trim(),
                            lastName: formData.lastName.trim(),
                            job: formData.job,
                        }
                        : emp,
                ),
            )
        }

        setIsDialogOpen(false)
    }

    const handleOpenDeleteConfirm = (employee: Employee) => {
        setDeleteConfirmEmployee(employee)
    }

    const handleConfirmDelete = () => {
        if (!deleteConfirmEmployee) return

        const id = deleteConfirmEmployee.id
        setEmployees((prev) => prev.filter((emp) => emp.id !== id))
        setDeleteConfirmEmployee(null)

        const newLength = filteredEmployees.length - 1
        const newTotalPages = Math.max(1, Math.ceil(newLength / ITEMS_PER_PAGE))
        if (currentPage > newTotalPages) {
            setCurrentPage(newTotalPages)
        }
    }

    const handleCancelDelete = () => {
        setDeleteConfirmEmployee(null)
    }

    const handleChangePage = (page: number) => {
        if (page < 1 || page > totalPages) return
        setCurrentPage(page)
    }

    return (
        <div className={styles.appContainer}>
            <div className={styles.card}>
                <div className={styles.cardHeader}>
                    <h1 className={styles.cardTitle}>Employee</h1>
                    <Button variant="primary" onClick={handleOpenAddDialog}>
                        Add
                    </Button>
                </div>

                <SearchBar
                    value={searchTerm}
                    onChange={(value) => {
                        setSearchTerm(value)
                        setCurrentPage(1)
                    }}
                />

                <EmployeeList
                    employees={paginatedEmployees}
                    onEdit={handleOpenEditDialog}
                    onDelete={handleOpenDeleteConfirm}
                />

                <Pagination
                    currentPage={currentPage}
                    totalPages={totalPages}
                    onChangePage={handleChangePage}
                />
            </div>

            <EmployeeDialog
                isOpen={isDialogOpen}
                mode={dialogMode}
                formData={formData}
                onChange={handleFormChange}
                onClose={handleDialogClose}
                onSubmit={handleDialogSubmit}
            />

            <ConfirmDialog
                employee={deleteConfirmEmployee}
                onCancel={handleCancelDelete}
                onConfirm={handleConfirmDelete}
            />
        </div>
    )
}

export default SimpleHr
