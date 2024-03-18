INSERT INTO room (room_number, room_type, has_minibar)
VALUES 
	(101, 'DOUBLE', true),
	(102, 'SINGLE', true),
	(103, 'SUITE', false);

INSERT INTO booking (booking_reference, room_number, guest_name, start_date, end_date)
VALUES
	('9e1ab59a-4909-4b7f-bd11-2694f2f365d4', 101, 'John Doe', '2024-03-18', '2020-03-25'),
	('374e977b-dd55-4528-b457-d0158af668ca', 102, 'Donald Duck', '2020-03-20', '2020-03-24'),
	('3328bf24-9247-4745-92dd-b59a57c10c6b', 102, 'Dagobert Duck', '2020-03-25', '2020-03-31'),
	('a3d0d365-9dc1-494b-9541-c252c88720d4', 103, 'Barbie & Ken', '2024-05-04', '2024-05-06');