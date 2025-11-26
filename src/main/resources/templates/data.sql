-- Datos de prueba para tablas evento y compra_entrada

SET FOREIGN_KEY_CHECKS = 0;
TRUNCATE TABLE compra_entrada;
TRUNCATE TABLE evento;
SET FOREIGN_KEY_CHECKS = 1;

-- Eventos
INSERT INTO evento (id, nombre, descripcion, fecha, lugar, precio_base, recargo_grada, recargo_vip) VALUES
(1, 'Concierto de Rock: Los Errantes', 'Banda de rock alternativo en gira nacional', '2025-06-15 20:00:00', 'Auditorio Nacional', 30.00, 5.00, 20.00),
(2, 'Teatro: La Vida Breve', 'Drama contemporáneo, versión renovada', '2025-05-10 19:30:00', 'Teatro Central', 20.00, 3.00, 12.00),
(3, 'Festival Gastronómico Ciudad', 'Productos locales y showcookings', '2025-08-02 11:00:00', 'Parque del Río', 15.00, 0.00, 0.00),
(4, 'Cloud Summit 2025', 'Conferencia sobre arquitectura en la nube', '2025-09-12 09:00:00', 'Palacio de Congresos', 100.00, 0.00, 50.00),
(5, 'Mercado de Artesanía', 'Puestos de artesanos locales y talleres', '2025-07-05 10:00:00', 'Plaza Mayor', 5.00, 0.00, 0.00),
(6, 'Concierto Pop: Estrellas', 'Gira del álbum "Noches de verano"', '2025-06-28 21:00:00', 'Estadio Municipal', 40.00, 8.00, 30.00),
(7, 'Exhibición: Arte Contemporáneo', 'Muestras de artistas emergentes', '2025-10-01 17:00:00', 'Museo de la Ciudad', 10.00, 0.00, 0.00),
(8, 'Partido Amistoso: Club A vs Club B', 'Encuentro amistoso entre clubes locales', '2025-04-20 18:00:00', 'Estadio Olímpico', 25.00, 10.00, 50.00);

-- Compras de entradas (precio_unitario y precio_total calculados de forma realista)
INSERT INTO compra_entrada (id, evento_id, nombre_comprador, email_comprador, numero_entrada, precio_unitario, precio_total, fecha_compra) VALUES
(1, 1, 'María López', 'maria.lopez@example.com', 2, 30.00, 60.00, '2025-05-02 14:23:00'),
(2, 1, 'Javier Ruiz', 'j.ruiz@gmail.com', 4, 50.00, 200.00, '2025-06-01 09:10:00'), -- VIP (30 + recargo 20 = 50.00)
(3, 2, 'Ana García', 'ana.garcia@yahoo.com', 1, 23.00, 23.00, '2025-04-29 11:45:00'), -- grada (20 + 3)
(4, 2, 'Teatro Lovers SL', 'ventas@teatrolovers.es', 10, 32.00, 320.00, '2025-05-01 10:00:00'), -- VIP (20 + 12)
(5, 3, 'Mercado Team', 'info@mercadoteam.es', 5, 15.00, 75.00, '2025-07-20 08:00:00'),
(6, 3, 'Carlos Fernández', 'carlosf@mail.com', 2, 15.00, 30.00, '2025-07-01 12:00:00'),
(7, 4, 'Laura Martínez', 'laura.m@example.com', 1, 150.00, 150.00, '2025-08-15 16:30:00'), -- VIP (100 + 50)
(8, 4, 'API Tickets SL', 'tickets@apitickets.com', 3, 100.00, 300.00, '2025-09-01 09:00:00'), -- base
(9, 5, 'Pablo Gómez', 'p.gomez@gmail.com', 4, 5.00, 20.00, '2025-06-25 18:20:00'),
(10, 6, 'Lucía Torres', 'lucia.torres@hotmail.com', 2, 48.00, 96.00, '2025-06-10 13:05:00'), -- grada (40 + 8)
(11, 6, 'Sociedad FanClub', 'fanclub@estrellas.com', 6, 70.00, 420.00, '2025-06-15 09:00:00'), -- VIP (40 + 30)
(12, 7, 'Ricardo Peña', 'rpena@correo.es', 1, 10.00, 10.00, '2025-09-20 11:11:00'),
(13, 8, 'Club A Abonos', 'abonos@cluba.es', 5, 35.00, 175.00, '2025-03-10 10:10:00'), -- grada (25 + 10)
(14, 8, 'Marta Núñez', 'marta.nunez@example.com', 2, 75.00, 150.00, '2025-04-01 15:45:00'), -- VIP (25 + 50)
(15, 1, 'Empresa Eventos SL', 'corporate@eventos.es', 50, 30.00, 1500.00, '2025-06-05 09:00:00'), -- compra masiva en base
(16, 2, 'Sofía Ortega', 'sofia.ortega@mail.com', 3, 20.00, 60.00, '2025-05-05 17:00:00'), -- platea base
(17, 4, 'Óscar Hidalgo', 'ohidalgo@techmail.com', 2, 100.00, 200.00, '2025-08-30 12:00:00'),
(18, 6, 'Elena Ruiz', 'elena.ruiz@correo.com', 1, 40.00, 40.00, '2025-06-20 19:00:00'),
(19, 5, 'Familia Castro', 'familia.castro@gmail.com', 3, 5.00, 15.00, '2025-07-01 09:30:00'),
(20, 3, 'Sergio Morales', 'sergio.m@example.com', 8, 15.00, 120.00, '2025-07-31 14:00:00');