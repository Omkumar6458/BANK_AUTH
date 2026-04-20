create table permission(
	id BIGSERIAL PRIMARY KEY,
	name VARCHAR(100) UNIQUE NOT NULL
	
);

CREATE TABLE role_permissions(
	role_id BIGINT NOT NULL,
	permission_id BIGINT NOT NULL,
	PRIMARY KEY(role_id, permission_id),
	CONSTRAINT fk_role_permission_role FOREIGN KEY(role_id) references roles(id),
	CONSTRAINT fk_role_permission_permission FOREIGN KEY(permission_id) references permission(id)
	
	
	
);


INSERT INTO PERMISSION(NAME) VALUES
('CREATE_ACCOUNT'),
('VIEW_ACCOUNT'),
('TRANSFER_MONEY'),
('APPROVE_TRANSACTION');
