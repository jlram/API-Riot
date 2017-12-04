public class Consulta {

    public void GET() throws IOException, JSONException {

        String content = "";

        URL urlFormed = new URL("https://euw1.api.riotgames.com/lol/champion-mastery/v3/champion-masteries/by-summoner/32148910?api_key=CLAVE_API");

        HttpURLConnection myConnection  = (HttpURLConnection) urlFormed.openConnection();

        myConnection.setRequestProperty("Accept", "application/json");

        if (myConnection.getResponseCode() == 200) {

            StringBuilder sb = new StringBuilder();

            InputStream responseBody = myConnection.getInputStream();

            InputStreamReader responseBodyReader = new InputStreamReader(responseBody, "UTF-8");

            BufferedReader bf = new BufferedReader(responseBodyReader);

            String line;

            while((line = bf.readLine()) != null){

                sb.append(line);

            }

            content = sb.toString();

            System.out.println(content);

            JSONObject json = new JSONObject();

            JSONArray results = json.getJSONArray(content);

            for (int i = 0; i<10; i++) {

                JSONObject obj = (JSONObject) results.get(i);

                System.out.println(obj.getJSONObject("from").getString("Name"));

            }

            bf.close();

        }


    }

}
