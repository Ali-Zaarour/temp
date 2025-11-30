import styles from './SearchBar.module.css';

interface Props {
    value: string;
    onChange?: (value: string) => void;
    placeholder?: string;
}

const SearchBar = ({ value, onChange, placeholder = "Search..." }: Props) => {
    return (
        <div className={styles.searchContainer}>
            <div className={styles.inputWrapper}>
                <input
                    type="text"
                    value={value}
                    placeholder={placeholder}
                    onChange={(e) => onChange?.(e.target.value)}
                />

                {value && (
                    <button
                        type="button"
                        className={styles.clearButton}
                        onClick={() => onChange?.("")}
                    >
                        ×
                    </button>
                )}
            </div>
        </div>
    );
};

export default SearchBar;
