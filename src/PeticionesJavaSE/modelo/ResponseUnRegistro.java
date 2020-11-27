/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PeticionesJavaSE.modelo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 *
 * @author rodsanchez
 */
public class ResponseUnRegistro {

@SerializedName("userId")
@Expose
private Integer userId;
@SerializedName("id")
@Expose
private Integer id;
@SerializedName("title")
@Expose
private String title;
@SerializedName("completed")
@Expose
private Boolean completed;

/**
* No args constructor for use in serialization
*
*/
public ResponseUnRegistro() {
}

/**
*
* @param id
* @param completed
* @param title
* @param userId
*/
public ResponseUnRegistro(Integer userId, Integer id, String title, Boolean completed) {
super();
this.userId = userId;
this.id = id;
this.title = title;
this.completed = completed;
}

public Integer getUserId() {
return userId;
}

public void setUserId(Integer userId) {
this.userId = userId;
}

public Integer getId() {
return id;
}

public void setId(Integer id) {
this.id = id;
}

public String getTitle() {
return title;
}

public void setTitle(String title) {
this.title = title;
}

public Boolean getCompleted() {
return completed;
}

public void setCompleted(Boolean completed) {
this.completed = completed;
}

}
