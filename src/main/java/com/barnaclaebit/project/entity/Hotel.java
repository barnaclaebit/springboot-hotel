package com.barnaclaebit.project.entity;

import java.util.Date;
import java.util.List;

import com.barnaclaebit.project.entity.dto.HotelDTO;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tb_hotel")
@Getter
@Setter
@EqualsAndHashCode
public class Hotel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cl_id")
	private long id;
	@Column(name = "cl_name")
	private String name;
	@Column(name = "cl_other_information")
	private String otherInformation;
	@OneToOne
	@PrimaryKeyJoinColumn()
	private Address address;
	@Column(name = "cl_since")
	private Date since;
	@Column(name = "cl_is_active")
	private boolean isActive;
	@OneToMany
	@PrimaryKeyJoinColumn()
	private List<Reserve> reservation;

	public HotelDTO modelToDTO() {
		return new HotelDTO(id, name, otherInformation, address, since, isActive, reservation);
	}

	public static Hotel dtoToHotel(HotelDTO hotelDTO) {
		if (hotelDTO == null) {
			return null;
		}

		Hotel hotel = new Hotel();
		hotel.name = hotelDTO.name();
		hotel.id = hotelDTO.id();
		hotel.address = hotelDTO.address();

		return hotel;
	}

}
