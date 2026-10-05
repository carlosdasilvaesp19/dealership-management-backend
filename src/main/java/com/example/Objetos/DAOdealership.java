package com.example.Objetos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;

import com.example.Exepciones.ExceptionUser;

public class DAOdealership {
    private Connection conec;

    public DAOdealership(Connection conec) throws SQLException {
        this.conec = conec;
    }

    public boolean añadirDealerShipSimple(Dealership d)
            throws SQLException, ExceptionUser {
        if (!(existeDealer(d.getDistrinetCode()))) {
            String sql = "INSERT INTO dealerships (distrinet_code, name, delivery_google_calendar_id) VALUES (?, ?, ?)";

            try (PreparedStatement ps = conec.prepareStatement(sql)) {

                ps.setString(1, d.getDistrinetCode());
                ps.setString(2, d.getName());
                ps.setString(3, d.getDeliveryGoogleCalendarId());

                ps.executeUpdate();
                return true;
            }
        }
        return false;
    }

    public boolean crearComplejo(Dealership d) throws SQLException, ExceptionUser {
        if (!(existeDealer(d.getDistrinetCode()))) {
            String sql = "INSERT INTO dealerships ("
                    + "distrinet_code, or_code, name, description, delivery_google_calendar_id, "
                    + "alias, full_address, location, phone, gmaps_url, "
                    + "schedule_1, schedule_2, mechanics_phone, mechanics_schedule_1, mechanics_schedule_2, "
                    + "bodywork_phone, bodywork_schedule_1, bodywork_schedule_2, renault_minute, extra, "
                    + "is_shown_emils_info, created_at, updated_at"
                    + ") VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

            try (PreparedStatement ps = conec.prepareStatement(sql)) {

                ps.setString(1, d.getDistrinetCode());
                ps.setString(2, d.getOrCode());
                ps.setString(3, d.getName());
                ps.setString(4, d.getDescription());
                ps.setString(5, d.getDeliveryGoogleCalendarId());
                ps.setString(6, d.getAlias());
                ps.setString(7, d.getFullAddress());
                ps.setString(8, d.getLocation());
                ps.setString(9, d.getPhone());
                ps.setString(10, d.getGmapsUrl());
                ps.setString(11, d.getSchedule1());
                ps.setString(12, d.getSchedule2());
                ps.setString(13, d.getMechanicsPhone());
                ps.setString(14, d.getMechanicsSchedule1());
                ps.setString(15, d.getMechanicsSchedule2());
                ps.setString(16, d.getBodyworkPhone());
                ps.setString(17, d.getBodyworkSchedule1());
                ps.setString(18, d.getBodyworkSchedule2());
                ps.setString(19, d.getRenaultMinute());
                ps.setString(20, d.getExtra());

                ps.setObject(21, d.getIsShownEmilsInfo());
                ps.setObject(22, d.getCreatedAt());
                ps.setObject(23, d.getUpdatedAt());

                ps.executeUpdate();
                return true;
            }
        }
        return false;
    }

    public boolean eliminar(String distrinet_code) throws SQLException {
        if (existeDealer(distrinet_code)) {
            String sql = "DELETE FROM dealerships WHERE distrinet_code = ?";
            try (PreparedStatement ps = conec.prepareStatement(sql)) {
                
                ps.setString(1, distrinet_code);
                int filas = ps.executeUpdate();
                return filas > 0;
            }
        }
        return false;
    }

    public Dealership buscarDealerSimple(String distrinetCode) throws SQLException, ExceptionUser {
        if (existeDealer(distrinetCode)) {
            String sql = "SELECT name, distrinet_code, delivery_google_calendar_id FROM dealerships WHERE distrinet_code = ?";
            Dealership d = null;
            try (PreparedStatement ps = conec.prepareStatement(sql)) {
                ps.setString(1, distrinetCode);

                try (ResultSet rs = ps.executeQuery()) {
                    if (rs.next()) {
                        d = new Dealership(rs.getString("distrinet_code"), rs.getString("name"),
                                rs.getString("delivery_google_calendar_id"));
                    }
                }
            }
            return d;
        }

        return null;
    }

    public Dealership buscarDealerComplejo(String distrinetCode) throws SQLException, ExceptionUser {
    if (existeDealer(distrinetCode)) {
        String sql = "SELECT * FROM dealerships WHERE distrinet_code = ?";
        Dealership d = null;

        try (PreparedStatement ps = conec.prepareStatement(sql)) {
            ps.setString(1, distrinetCode);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    String dCode = rs.getString("distrinet_code");
                    String orCode = rs.getString("or_code");
                    String name = rs.getString("name");
                    String desc = rs.getString("description");
                    String calendarId = rs.getString("delivery_google_calendar_id");
                    String alias = rs.getString("alias");
                    String address = rs.getString("full_address");
                    String loc = rs.getString("location");
                    String phone = rs.getString("phone");
                    String gmaps = rs.getString("gmaps_url");
                    String sch1 = rs.getString("schedule_1");
                    String sch2 = rs.getString("schedule_2");
                    String mPhone = rs.getString("mechanics_phone");
                    String mSch1 = rs.getString("mechanics_schedule_1");
                    String mSch2 = rs.getString("mechanics_schedule_2");
                    String bPhone = rs.getString("bodywork_phone");
                    String bSch1 = rs.getString("bodywork_schedule_1");
                    String bSch2 = rs.getString("bodywork_schedule_2");
                    String rMinute = rs.getString("renault_minute");
                    String extra = rs.getString("extra");
                    
                    boolean emilsInfo = rs.getBoolean("is_shown_emils_info");                    
                    LocalDateTime created = rs.getObject("created_at", java.time.LocalDateTime.class);
                    LocalDateTime updated = rs.getObject("updated_at", java.time.LocalDateTime.class);
                    d = new Dealership(dCode, orCode, name, desc, calendarId, alias, address, loc, phone, gmaps, sch1, sch2, mPhone, mSch1, mSch2, bPhone, bSch1, bSch2, rMinute, extra, emilsInfo, created, updated);
                }
            }
        }
        return d;
    }

    return null;
}

    public ArrayList<Dealership> listarSimple() throws SQLException, ExceptionUser {
        String sql = "SELECT distrinet_code, name, delivery_google_calendar_id FROM dealerships";
        ArrayList<Dealership> lista = new ArrayList<>();

        try (PreparedStatement ps = conec.prepareStatement(sql);
                ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                String code = rs.getString("distrinet_code");
                String name = rs.getString("name");
                String calendarId = rs.getString("delivery_google_calendar_id");

                Dealership d = new Dealership(code, name, calendarId);

                lista.add(d);
            }
        }

        return lista;
    }

   public ArrayList<Dealership> listarComplejo() throws SQLException, ExceptionUser {
    String sql = "SELECT * FROM dealerships";
    ArrayList<Dealership> lista = new ArrayList<>();

    try (PreparedStatement ps = conec.prepareStatement(sql);
         ResultSet rs = ps.executeQuery()) {

        while (rs.next()) {
            String distrinetCode = rs.getString("distrinet_code");
            String orCode = rs.getString("or_code");
            String name = rs.getString("name");
            String description = rs.getString("description");
            String calendarId = rs.getString("delivery_google_calendar_id");
            String alias = rs.getString("alias");
            String fullAddress = rs.getString("full_address");
            String location = rs.getString("location");
            String phone = rs.getString("phone");
            String gmapsUrl = rs.getString("gmaps_url");
            String schedule1 = rs.getString("schedule_1");
            String schedule2 = rs.getString("schedule_2");
            String mechanicsPhone = rs.getString("mechanics_phone");
            String mechanicsSchedule1 = rs.getString("mechanics_schedule_1");
            String mechanicsSchedule2 = rs.getString("mechanics_schedule_2");
            String bodyworkPhone = rs.getString("bodywork_phone");
            String bodyworkSchedule1 = rs.getString("bodywork_schedule_1");
            String bodyworkSchedule2 = rs.getString("bodywork_schedule_2");
            String renaultMinute = rs.getString("renault_minute");
            String extra = rs.getString("extra");
            Boolean isShownEmilsInfo = rs.getBoolean("is_shown_emils_info");

            java.time.LocalDateTime createdAt = rs.getObject("created_at", java.time.LocalDateTime.class);
            java.time.LocalDateTime updatedAt = rs.getObject("updated_at", java.time.LocalDateTime.class);

            Dealership d = new Dealership(distrinetCode, orCode, name, description, calendarId, alias,
                    fullAddress, location, phone, gmapsUrl, schedule1, schedule2, mechanicsPhone,
                    mechanicsSchedule1, mechanicsSchedule2, bodyworkPhone, bodyworkSchedule1, bodyworkSchedule2,
                    renaultMinute, extra, isShownEmilsInfo, createdAt, updatedAt);

            lista.add(d);
        }
    } 
    
    return lista; }

    public boolean modificarComplejo(Dealership d) throws SQLException, ExceptionUser {
        if (existeDealer(d.getDistrinetCode())) {
            String sql = "UPDATE dealerships SET "
                    + "or_code = ?, name = ?, description = ?, delivery_google_calendar_id = ?, alias = ?, "
                    + "full_address = ?, location = ?, phone = ?, gmaps_url = ?, schedule_1 = ?, schedule_2 = ?, "
                    + "mechanics_phone = ?, mechanics_schedule_1 = ?, mechanics_schedule_2 = ?, bodywork_phone = ?, "
                    + "bodywork_schedule_1 = ?, bodywork_schedule_2 = ?, renault_minute = ?, extra = ?, "
                    + "is_shown_emils_info = ?, updated_at = ? "
                    + "WHERE distrinet_code = ?";

            try (PreparedStatement ps = conec.prepareStatement(sql)) {
                ps.setString(1, d.getOrCode());
                ps.setString(2, d.getName());
                ps.setString(3, d.getDescription());
                ps.setString(4, d.getDeliveryGoogleCalendarId());
                ps.setString(5, d.getAlias());
                ps.setString(6, d.getFullAddress());
                ps.setString(7, d.getLocation());
                ps.setString(8, d.getPhone());
                ps.setString(9, d.getGmapsUrl());
                ps.setString(10, d.getSchedule1());
                ps.setString(11, d.getSchedule2());
                ps.setString(12, d.getMechanicsPhone());
                ps.setString(13, d.getMechanicsSchedule1());
                ps.setString(14, d.getMechanicsSchedule2());
                ps.setString(15, d.getBodyworkPhone());
                ps.setString(16, d.getBodyworkSchedule1());
                ps.setString(17, d.getBodyworkSchedule2());
                ps.setString(18, d.getRenaultMinute());
                ps.setString(19, d.getExtra());

                ps.setObject(20, d.getIsShownEmilsInfo());
                ps.setObject(21, java.time.LocalDateTime.now());

                ps.setString(22, d.getDistrinetCode());

                int filasAfectadas = ps.executeUpdate();
                return filasAfectadas > 0;
            }
        }
        return false;
    }

    public boolean existeDealer(String distrinetCode) throws SQLException {
        String sql = "SELECT 1 FROM dealerships WHERE distrinet_code = ? LIMIT 1";

        try (PreparedStatement ps = conec.prepareStatement(sql)) {
            ps.setString(1, distrinetCode);

            try (ResultSet rs = ps.executeQuery()) {
                return rs.next();
            }
        }
    }
}
