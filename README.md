## sim-card-api
REST API to handle sim card details <br>
[Link](https://sim-card-api-1210.herokuapp.com/api/)<br>

| API End Point      | Description | HTTP Method     |
| :---        |    :----:   |          ---: |
| /listall      | To desplay all simcard details       | GET method   |
| /add   | To add simcard details        | POST method      |
| /{id}   | To Update simcard details        | PUT method      |
| /{id}  | To Delete simcard details        | DELETE method      |
| /to-renew  | To find simcard details going to expire int next 30 days        | GET method      |
| /renew/{id}  | To renew sim card validity       | PUT method      | 
<br>


| SIMCARD details       | Type | 
| :---        |    :----:   |  
| Sim_card_no      | NUMBER      |
| Mobile_no      | NUMBER      |
| Status     | String      |
| Expiry_date     | DATE      |
| Registration_date     | DATE      |
| State_of_registration    | String      |
| KYC    | String      |
| Telecom_Provider    | String      |
| Full_name    | String      |
