import styles from './Pagination.module.css'
import Button from './Button'

interface Props {
    currentPage: number
    totalPages: number
    onChangePage: (page: number) => void
}

const Pagination = ({currentPage, totalPages, onChangePage}: Props) => {
    return (
        <div className={styles.pagination}>
            <Button size="small" onClick={() => onChangePage(currentPage - 1)} disabled={currentPage === 1}>
                {'<'}
            </Button>

            <span className={styles.paginationInfo}>Page {currentPage} of {totalPages}</span>

            <Button size="small" onClick={() => onChangePage(currentPage + 1)} disabled={currentPage === totalPages}>
                {'>'}
            </Button>
        </div>
    )
}

export default Pagination
