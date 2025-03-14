package br.com.vendetudo.marketplace.modules.user.exceptions;

public class EmailAlreadyRegisteredException extends RuntimeException{

   public  EmailAlreadyRegisteredException(){
       super("Email ja registrado");
   }


}
