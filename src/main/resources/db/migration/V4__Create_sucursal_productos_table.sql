CREATE TABLE sucursal_productos (
    sucursal_id BIGINT NOT NULL,
    producto_id BIGINT NOT NULL,
    stock INT NOT NULL,
    PRIMARY KEY (sucursal_id, producto_id),
    FOREIGN KEY (sucursal_id) REFERENCES sucursales(id),
    FOREIGN KEY (producto_id) REFERENCES productos(id)
);
