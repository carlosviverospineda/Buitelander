package com.domiciliosenvia.domicilio.web.solicitud.mensajes.sms;

///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package com.saviasaludeps.savia.web.solicitud.mensajes.sms;
//
//import com.google.gson.Gson;
//import com.google.gson.GsonBuilder;
//import com.google.gson.JsonSyntaxException;
////import com.saviasaludeps.savia.dominio.solicitud.GsNotificacion;
////import com.saviasaludeps.savia.negocio.solicitud.GsNotificacionRemoto;
//import com.saviasaludeps.savia.web.utilidades.PropApl;
//import com.saviasaludeps.savia.web.utilidades.RemotoEJB;
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStream;
//import java.io.InputStreamReader;
//import java.io.OutputStreamWriter;
//import java.net.HttpURLConnection;
//import java.net.MalformedURLException;
//import java.net.URL;
//import java.nio.charset.StandardCharsets;
//import java.util.Base64;
//import java.util.Date;
//import javax.ws.rs.core.MediaType;
//import org.primefaces.shaded.json.JSONException;
//
///**
// *
// * @author jramirez
// */
//public class SMSSolicitudesWeb implements Runnable{
//    private GsNotificacionRemoto getGsNotificacionRemoto() throws Exception {
//        return (GsNotificacionRemoto) RemotoEJB.getEJBRemoto("GsNotificacionServicio", GsNotificacionRemoto.class.getName());
//    }
//
//    public SMSSolicitudesWeb(GsNotificacion notificacion) {
//        this.notificacion = notificacion;
//    }
//
//    private static final String SEPARADOR_CELULARES = ",";
//
//    private static final String URL = PropApl.getInstance().get(PropApl.SMS_REST_TIGO_URL);
//    private static final String USUARIO = PropApl.getInstance().get(PropApl.SMS_REST_TIGO_USER);
//    private static final String PASSWORD = PropApl.getInstance().get(PropApl.SMS_REST_TIGO_PWD);
//    private static final String PAIS_CODIGO = PropApl.getInstance().get(PropApl.SMS_REST_TIGO_COUNTRY);
//    private static final String TIPO_CONSUMO = PropApl.getInstance().get(PropApl.SMS_WS_TIGO_CONSUMO);
//
//    private final GsNotificacion notificacion;
//
//    @Override
//    public void run() {
//        GsonBuilder gsonBuilderRespuesta = new GsonBuilder();
//        gsonBuilderRespuesta.setDateFormat("yyyy-MM-dd HH:mm:ss");
//        gsonBuilderRespuesta.serializeNulls();
//        Gson gson = gsonBuilderRespuesta.create();
//        RespDTO respuesta = null;
//        switch (TIPO_CONSUMO) {
//            case "GET":
//                respuesta = consumoServicioGET(notificacion);
//                break;
//            case "POST":
//                respuesta = consumoServicioPOST(notificacion);
//                break;
//        }
//        try {
//            notificacion.setFechaHoraModifica(new Date());
//            if (respuesta == null) {
//                notificacion.setEstado(GsNotificacion.ESTADO_FALLIDO);
//                getGsNotificacionRemoto().actualizar(notificacion);
//            } else {
//                notificacion.setEstado(GsNotificacion.ESTADO_ENVIADO);
//                getGsNotificacionRemoto().actualizar(notificacion);
//            }
//        } catch (Exception ex) {
//
//        }
//    }
//
//    private static RespDTO consumoServicioGET(GsNotificacion notificacion) {
//        RespDTO respuesta = null;
//        try {
//            String httpUrl = SMSSolicitudesWeb.URL + "?mobile=" + notificacion.getCelular() + "&country=" + SMSSolicitudesWeb.PAIS_CODIGO + "&messageFormat=" + "1" + "&message=" + notificacion.getDetalle().trim().replaceAll(" ", "+");
//            //Objeto GSON
//            GsonBuilder gsonBuilderRespuesta = new GsonBuilder();
//            gsonBuilderRespuesta.setDateFormat("yyyy-MM-dd"); //Formato fecha 
//            gsonBuilderRespuesta.serializeNulls();
//            Gson gson = gsonBuilderRespuesta.create();
//            //Inicio consumos
//            URL url = new URL(httpUrl);
//            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
//            conn.setDoOutput(true);
////            conn.setRequestProperty("Content-Type", "application/json");
////            conn.setRequestProperty("Connection", "Keep-Alive");
////            conn.setRequestProperty("Host", "<calculated when request is sent>");
//            String authString = SMSSolicitudesWeb.USUARIO + ":" + SMSSolicitudesWeb.PASSWORD;
//            String authStringEnc = Base64.getEncoder().encodeToString(authString.getBytes(StandardCharsets.UTF_8));
//            conn.setRequestProperty("Authorization", "Basic " + authStringEnc);
//            conn.setRequestMethod("GET");
//            //Lectura por linea
//            InputStream ins = conn.getInputStream();
//            InputStreamReader isr = new InputStreamReader(ins);
//            try (BufferedReader in = new BufferedReader(isr)) {
//                String inputLine;
//                String result = "";
//                while ((inputLine = in.readLine()) != null) {
//                    result += inputLine;
//                }
//                respuesta = gson.fromJson(result, RespDTO.class);
//            }
//        } catch (MalformedURLException ex) {
//            respuesta = null;
//        } catch (IOException | JsonSyntaxException | JSONException ex) {
//            respuesta = null;
//        }
//        return respuesta;
//    }
//
//    private static RespDTO consumoServicioPOST(GsNotificacion notificacion) {
//        RespDTO respuesta = null;
//        try {
//            //Objeto GSON
//            GsonBuilder gsonBuilderRespuesta = new GsonBuilder();
//            gsonBuilderRespuesta.setDateFormat("yyyy-MM-dd"); //Formato fecha 
//            gsonBuilderRespuesta.serializeNulls();
//            Gson gson = gsonBuilderRespuesta.create();
//            //Llenar DTO
//            String jsonEntrada = gson.toJson(null);
//            //Inicio consumos
//            URL url = new URL(SMSSolicitudesWeb.URL);
//            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
//            conn.setDoOutput(true);
//            conn.setRequestMethod("POST");
//            String authString = SMSSolicitudesWeb.USUARIO + ":" + SMSSolicitudesWeb.PASSWORD;
//            String authStringEnc = Base64.getEncoder().encodeToString(
//                    authString.getBytes(StandardCharsets.UTF_8)
//            );
//            conn.setRequestProperty("Content-Type", MediaType.APPLICATION_JSON);
//            conn.setRequestProperty("Authorization", "Basic " + authStringEnc);
//            conn.setRequestProperty("Connection", "Keep-Alive");
//            conn.setDoOutput(true);
//            //Conexion y carga de variables
//            InputStreamReader inputStreamReader;
//            int len = jsonEntrada.length();
//            conn.connect();
//            //carga de parámetros
//            OutputStreamWriter outStr = new OutputStreamWriter(conn.getOutputStream());
//            outStr.write(jsonEntrada, 0, len);
//            outStr.flush();
//            InputStream inputStream = conn.getInputStream();
//            inputStreamReader = new InputStreamReader(inputStream, "UTF-8");
//            try (BufferedReader bufferedReader = new BufferedReader(inputStreamReader)) {
//                String inputLine;
//                String result = "";
//                while ((inputLine = bufferedReader.readLine()) != null) {
//                    result += inputLine;
//                }
//                respuesta = gson.fromJson(result, RespDTO.class);
//            }
//        } catch (MalformedURLException ex) {
//            respuesta = null;
//        } catch (IOException | JsonSyntaxException | JSONException ex) {
//            respuesta = null;
//        }
//        return respuesta;
//    }
//}
