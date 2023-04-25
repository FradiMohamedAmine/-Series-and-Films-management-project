package com.example.Service;

import com.example.DAO.DAO_Episode;
import com.example.DAO.DAO_notif;
import com.example.Entities.*;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class ServiceNotif {
    public void ajoutAutomatiqueNotficationsDunUtilisateur(Episode e ){
        String message = "\"Hey there! Just wanted to let you know that a new episode of "+e.getNomSerie()+" called "+e.getNomSerie()+" has just been added.In this episode, "+e.getResume()+" .You can go ahead and watch it now on Cinephoria. Happy watching!";

        ServiceUtilisateur serviceUtilisateur = new ServiceUtilisateur();
        List<Utislisateur> utislisateurListquiPreferecetSerie = serviceUtilisateur.afficherTous().stream().filter(z->z.getSeriesFavoris().stream().filter(x-> x.getTitre().equals(e.getNomSerie())).anyMatch(x->true) ).collect(Collectors.toList());
        for (Utislisateur u : utislisateurListquiPreferecetSerie){
            Notification n =new Notification(u,message);
            if(!contientNotificationsDunUtilisateur(n,u)){
                     DAO_notif.insererNotification(n);
                }
        }
    }
    public static boolean contientNotificationsDunUtilisateur(Notification n,Utislisateur u) {
        return DAO_notif.findAll(u.getNomprenom()).stream().filter(x->(x.getMessage().equals(n.getMessage()))).anyMatch(x->true);
    }

    public List<Notification> afficherToutesNotficationsDunUtilisateur(String nomUtilisateur){
        supprissionAutomatiqueNotficationsDunUtilisateur(nomUtilisateur);
        return afficherToutesNotficationsDunUtilisateur(nomUtilisateur);
    }





    public void supprissionAutomatiqueNotficationsDunUtilisateur(String nomUtilisateur){
        List<Notification> notificationList = afficherToutesNotficationsDunUtilisateur(nomUtilisateur);
        LocalDate now = LocalDate.now() ;
        for(Notification n : notificationList){
            if(n.getDate_de_mise().isBefore(now.minusDays(60))){
                DAO_notif.deleteNotification(n);
            }
        }
    }





}
