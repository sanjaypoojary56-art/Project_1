from flask import Flask ,render_template,request
import pdfplumber
import os
from google import genai as gimini

app=Flask(__name__)
app.config["UPLOAD_FOLDER"]="uploads"
@app.route("/",methods=["GET","POST"])
def home():
    text=""
    result1=""
    if request.method=="POST":
        file=request.files["resume"];
        if file:
            path=os.path.join(app.config["UPLOAD_FOLDER"],file.filename)
            file.save(path)
            with pdfplumber.open(path)as pdf:
                for page in pdf.pages:
                    if page.extract_text:
                        text+=page.extract_text()
            result1=ai_response(text)            
    return render_template("index.html",result=result1)
def ai_response(text):
    client=gimini.Client(api_key="AIzaSyCE7CrK6KkhQz_Xj3SFHaQqbbYblCD9KWE")
    response=client.models.generate_content(model="gemini-2.5-flash",contents=f" First give greetings like hello i am here and then Analyze the resume and give improvements suggestions  and give short and sweet \n:{text}")
    return response.text
    
  
if __name__=="__main__":
    port=int(os.environ.get("PORT",5000))
    app.run(host="0.0.0.0",port=port)
