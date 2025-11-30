import styles from './Button.module.css'
import type {ButtonHTMLAttributes, ReactNode} from "react";

interface Props extends ButtonHTMLAttributes<HTMLButtonElement> {
    children: ReactNode;
    variant?: 'default' | 'primary' | 'danger';
    size?: 'normal' | 'small';
    type?: 'button' | 'submit';
}

const Button = ({children, variant = 'default', size = 'normal', type = 'button', ...rest}: Props) => {

    const classes = [
        styles.btn, variant === 'primary' ? styles.primary : '',
        variant === 'danger' ? styles.danger : '',
        size === 'small' ? styles.small : '',
    ].filter(Boolean).join(' ');

    return (
        <button type={type} className={classes} {...rest}>
            {children}
        </button>
    )
}

export default Button
