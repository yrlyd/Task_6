/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;
import twitter4j.*;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Toshiba
 */
public class TwitterModel {
    private Twitter twitter;
    
    public TwitterModel() {
        twitter = new TwitterFactory().getInstance();
    }
    
    public void tweetStatus(String tweet) {
        try {
            twitter.updateStatus(tweet);
            JOptionPane.showMessageDialog(null, "pesan berhasil");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Pesan error","error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public String getHomeTimeline() {
        try {
            String s = "";
            List<Status> status = twitter.getHomeTimeline();
            for (int i = 0; i < status.size(); i++) {
                s = s + status.get(i).getUser().getScreenName() + " - "
                        + status.get(i).getText() + "\n";
            }
            return s;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"pesan error","Error", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }
    
    public void followUser(String user) {
        try {
            twitter.createFriendship(user);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Pesan error","Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
