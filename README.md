#TP EVAL Interopérabilité 2020

### Ex1
Le service SOAP s'exécute bien en lançant **AvisServiceRunner** et donne bien le WSDL à l'adresse :  
http://localhost:9090/AvisService?wsdl

### Ex2
Le service REST effectue bien un "Spring Boot Run" lorsque je lance **PlantationRestServiceApplication**, il suffit ensuite de se servir de Postman ou SOAP UI pour interagir avec le service.


### Ex3
Pour lancer le service de messagerie, il faut dans la classe **ClientInteropMessenger**, pour envoyer un message, s'assurer que les lignes 43 à 62 
(commençant par `URI uri = new URI(baseUrl);` et finissant par `System.out.println("le code retour est : "+ result.getStatusCodeValue());`) ne sont pas mis en commentaire et inversement pour 
les lignes 66 à 82 (commençant par `ResponseEntity<Message[]> response;` et finissant par `}`)

La classe **ClientInteropMessenger** peut alors être exécutée, un premier message "Hello there !" sera envoyé et vous pouvez aussi écrire un message sur la console de votre IDE Java.

Pour recevoir un message, il faut faire l'inverse par rapport à l'envoie, mettre en commentaire les lignes 43 à 62 et décommenter les lignes 66 à 82.
Vous refaites l'exécution de la classe **ClientInteropMessenger** et vous recevrez les messages envoyés à l'instant.