package dev.alizaarour.demo.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Timestamp;
import java.util.UUID;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "app_user_permission")
public class AppUserPermission {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;

    @Column(name = "key", nullable = false, unique = true, length = 50)
    private String key;

    @UpdateTimestamp
    @Column(name = "updated_at")
    protected Timestamp updatedAt;

    @Column(name = "deleted_at")
    protected Timestamp deletedAt;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    protected Timestamp createdAt;

}
