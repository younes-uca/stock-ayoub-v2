Feature: EtatAvoirAchat

  Background:
    * call read('karate-config.js')
    * call read('db_cleaner.js')
    * url etatAvoirAchatUrl
    * header Content-Type = 'application/json'

    * def postBody = read('EtatAvoirAchatSave.json')
    * def FindAllSchema = read('EtatAvoirAchatSchema.json')

  Scenario: Fail - GetByID Not Found

    * path 'id', 99999999
    * header Authorization = 'Bearer ' + adminToken
    * method GET
    * status 404
    * match response.length == 0



  Scenario: Fail - POST EtatAvoirAchat without Body

    * path ''
    * header Authorization = 'Bearer ' + adminToken
    * method POST
    * status 400
    * match response.error == "Bad Request"



  Scenario: Fail - POST EtatAvoirAchat without Authorization

    * path ''
    * header Authorization = 'Bearer unvalid'
    * request postBody
    * method POST
    * status 500



  Scenario: Fail - Save EtatAvoirAchat with method PATCH

    * path ''
    * header Authorization = 'Bearer ' + adminToken
    * method PATCH
    * status 405
    * match response.error == "Method Not Allowed"