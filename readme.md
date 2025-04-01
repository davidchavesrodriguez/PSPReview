# DU3 and DU4 - Clemenraffle - Review exercise

We want to implement a multi-threaded Java server that simulates a service that sells tickets for a raffle and then conducts the raffle. The goal is to program a client-server system over TCP in which multiple clients connect to the server to purchase raffle tickets. The server maintains a list of tickets sold.

The commands to be used must be case insensitive. They are as follows:

·       CLIENT <client-name>. This command registers a client (client-name) in the system.

·       BUY. This command allows a registered client to purchase a raffle.

·       CALC. This command calculates and returns the winning probability of a raffle.

·       QUIT. This command disconnects the client.

The server responses are as follows:

A.      Welcome to ClemenRaffle service. The server sends this message when a client connects to it.

B.      Hello <client-name>. The server registers the client's name to respond to a CLIENT command.

C.       <client-name>- Client name is not modifiable. The client already has a name, and it cannot be changed. This is another answer to a CLIENT command.

D.      Client name required. The client has not been registered yet. The client must be registered prior to use the commands BUY or CALC.

E.       <client-name>- <client-name> has got the raffle <ticket-code>. The client has successfully purchased a ticket using the BUY command. The <ticket-code> is randomly generated.

F.       <client-name>- Ticket sales are closed. The client attempts to purchase a ticket when all tickets are sold.

G.      <client-name>- The odds are 1/n. The server responds to a CALC command by calculating the probability of winning as 1/total_tickets where total_tickets is the total number of tickets currently sold.

H.      <client-name>- The raffle has ended. The server responds to a CALC command with this message after all tickets have been sold.

I.      <client-name>- Unknown command. The client has sent a command that does not exist. <client-name>- Bye. Says bye to the user (client-name) when the client sends a QUIT command.

Whenever the client is not registered, its client-name must be null.

Create a Ticket class to store the client name, the number of chars to be used in the ticket and the value of the ticket. Create setters and getters, a toString method and a method to generate the value for the ticket. The generateValue() method generates a random code consisting of uppercase letters (A-Z) and digits (0-9), of a length specified by numChars.

Create a RaffleServer class with a main method. The class has three constants, one that defines the maximum number of tickets to be sold, another one that defines the length of ticket codes, and another that defines the port on which the server listens (55555). It also has a list of sold tickets, and a Winner object to store the winning ticket. The server is constantly waiting for new client connections and creates a new thread for each connection. All threads must share the array of Ticket and the Winner object. The server must display information about its activity in the standard output indicating the client name and the requested command whenever possible.

Create the Winner class to store information about the winning client and ticket

Create a RaffleServerWorker class responsible for handling individual client connections on the raffle server. It processes client commands and manages ticket purchases, probability calculations, and the winner selection process.

Create a method to serve each of the client's requests. The server must always display information about its activity in the standard output. The thread stops executing when the client notifies that it is leaving.

Modify the RaffleServerWorker code so that when all tickets are sold, the server closes sales and randomly selects a winner. After the winner has been selected, no more clients trigger the winner process. The server sends an email to each client. The winner receives a special email. To send the mail, the server launches another thread that throws a new SendMail class. The SendMail class must receive the winner information, the information of a Ticket, and a Boolean variable indicating if the developer wants to send the mail using the test credentials or if they want to work with production credentials. In this exam only the test sending must be implemented.

Implement the SendMail class. Use a properties file to store the credentials. in Mailtrap. Add the Angus Mail dependencies to the pom.xml. Use loserConfirmation.html and winnerConfirmation.html as mail templates. Use noreply@clemenraffle.gal as the sender mail. The mail to use as destination must be in the clemenraffle.gal domain, so if the user's name is ernesto, send the mail to ernesto@clementrain.gal. Send a blind carbon copy to admin@clemenraffle.gal. The subject of the email must be: "Clemenraffle winner confirmation" if the client has won the raffle and "Clemenraffle information" if the client has not won. The following images show how the mails must look like. You must replace NAME with the name of the customer and TICKET_NUMBER with the ticket number purchased by the client. Embed the logo image in the email using Content-ID.

Save in the project directory a copy of the sent mail in a file called client-name_ticket-code-W.html (example: sonia-QDTX3P-W.html) for the winner and client-name_ticket-code-L.html (example: marga-H5RZER-L.html) for losers.

Set up a user with your name on the Serva FTP server and start the service. Configure a folder called ftp inside the D drive that will be used as the user's root directory. Place the file clemenraffle-logo.png in the ftp folder.

Modify the server code so that it launches another thread using a new UploadMails class to upload to the Serva FTP server all the mails sent. Before uploading the files, wait for the email threads using a join method. The UploadMails class must upload all emails to the user's folder on the server.

Implement the UploadMails class to upload all the email files to the server (all files whose extension is .html) and no other files in the project directory. Once uploaded to the server, delete the email files from the current directory. Remember to add the Apache Commons Net dependency.
