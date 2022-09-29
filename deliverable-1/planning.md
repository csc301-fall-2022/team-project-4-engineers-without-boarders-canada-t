# Engineers Without Boarders/Missing Seven
> _Note:_ This document is meant to evolve throughout the planning phase of your project.   That is, it makes sense for you commit regularly to this file while working on the project (especially edits/additions/deletions to the _Highlights_ section). Most importantly, it is a reflection of all the planning you work you've done in the first iteration. 
 > **This document will serve as a master plan between your team, your partner and your TA.**

## Product Details
 
#### Q1: What are you planning to build?

 > Short (1 - 2 min' read)
 * Start with a single sentence, high-level description of the product.
 * Be clear - Describe the problem you are solving in simple terms.
 * Be concrete. For example:
    * What are you planning to build? Is it a website, mobile app,
   browser extension, command-line app, etc.?      
    * When describing the problem/need, give concrete examples of common use cases.
    * Assume your the reader knows nothing about the problem domain and provide the necessary context. 
 * Focus on *what* your product does, and avoid discussing *how* you're going to implement it.      
   For example: This is not the time or the place to talk about which programming language and/or framework you are planning to use.
 * **Feel free (and very much encouraged) to include useful diagrams, mock-ups and/or links**.
 * The project is to develop an Android App to simulate the Engineers Without Boarders workshop on water filter building practice.
 * Many people in this world do not have access to clean water, the workshop is aimed at improving peoples' awareness on difficulties accessing clean water in different countries, and the target users are mostly high school students and teachers.
 * The onsite workshop generally have small capacity, there are no enough public locations to hold the workshop, and it is difficult to get all equipments needed in some countries
 * The app is an replacement to the onsite workshop as people can download the app and start the workshop, more people are involved.


#### Q2: Who are your target users?

https://workspace5276499.xtensio.com/pzg7libj

#### Q3: Why would your users choose your product? What are they using today to solve their problem/need?

> Short (1 - 2 min' read max)
 * We want you to "connect the dots" for us - Why does your product (as described in your answer to Q1) fits the needs of your users (as described in your answer to Q2)?
 * Explain the benefits of your product explicitly & clearly. For example:
    * Save users time (how much?)
    * Allow users to discover new information (which information? And, why couldn't they discover it before?)
    * Provide users with more accurate and/or informative data (what kind of data? Why is it useful to them?)
    * Does this application exist in another form? If so, how does your differ and provide value to the users?
    * How does this align with your partner's organization's values/mission/mandate?
   
    We believe the users would choose our Water For The World (W4TW) mobile app not only because of its customizable user interface with other interesting and useful functionalities but also because this app comes in many different forms and is easy to get started.
    Firstly, our W4TW mobile app can definitely save users’ time, since the original format of W4TW is happening during an in-person workshop, so normally it will take the W4TW members a long time on the road to meet at the same place. By using our app, they can skip the process of going to the meeting, instead, they can just stay at home and use our app to connect online which saves the users tons of time.
    Secondly, the users have many different ways to discover and learn new information and technologies from our W4TW mobile app. W4TW workshop is designed to teach volunteers about water filter building knowledge, so definitely there are tons of knowledge to learn and we will make sure to include those in our app even with specific video. We decided to divide that information and pair them with related game functionalities, so the users can play and learn at the same time. All the information and knowledge will directly come from the official W4TW website and summarize from the previous hundreds of in-person workshops, so of course, the information is accurate and reliable. 
    Thirdly, our W4TW mobile app has many forms and can be used even under difficult circumstances.  As the partner mentioned during our weekly meeting, some of the W4TW users might not have the access to the internet, so our app will be including an offline mode which allows the users to ignore the limitations of the internet and access and use the app, so once the user gets our app installed, they can use it even without internet. When the phone connects to the internet, our app will automatically upload the data online. 



#### Q4: How will you build it?

> Short (1-2 min' read max)
 * What is the technology stack? Specify any and all languages, frameworks, libraries, PaaS products or tools. 

 * We will be using Android Studio to build an Android App based on Jetpack Compose
 * Language: Kotlin
 * libraries: Jetpack Compose

 * How will you deploy the application?
 * We will use the Android Studio tools to Build APK

 * Describe the architecture - what are the high level components or patterns you will use? Diagrams are useful here. 
 * MVVM + clean architecture pattern, we will use Jetpack Compose to make the UI of the app, use view models to integrate API responses
![plot](./ImageRes/Missing%20Seven%20Architecture.drawio.png)

 * Will you be using third party applications or APIs? If so, what are they?
 * Currently not found any

 * What is your testing strategy?
 * We will write unittests on every functions in the model classes and viewModel classes, for the UI classes, we will test them on the Android emulator/physical devices

#### Q5: What are the user stories that make up the MVP?
https://drive.google.com/file/d/1FtkFjvEuns3qunmjAE3l3A_F8x8FFtKy/view?usp=sharing
----
## Intellectual Property Confidentiality Agreement 
> Note this section is **not marked** but must be completed briefly if you have a partner. If you have any questions, please ask on Piazza.
>  
**By default, you own any work that you do as part of your coursework.** However, some partners may want you to keep the project confidential after the course is complete. As part of your first deliverable, you should discuss and agree upon an option with your partner. Examples include:
1. You can share the software and the code freely with anyone with or without a license, regardless of domain, for any use.
2. You can upload the code to GitHub or other similar publicly available domains.
3. You will only share the code under an open-source license with the partner but agree to not distribute it in any way to any other entity or individual. 
4. You will share the code under an open-source license and distribute it as you wish but only the partner can access the system deployed during the course.
5. You will only reference the work you did in your resume, interviews, etc. You agree to not share the code or software in any capacity with anyone unless your partner has agreed to it.

**Briefly describe which option you have agreed to. Your partner cannot ask you to sign any legally binding agreements or documents pertaining to non-disclosure, confidentiality, IP ownership, etc.**

----

## Process Details

#### Q6: What are the roles & responsibilities on the team?

Describe the different roles on the team and the responsibilities associated with each role. 
 * Roles should reflect the structure of your team and be appropriate for your project. Not necessarily one role to one team member.  
 * Add role(s) to your Team-[Team_Number]-[Team_Name].csv file on the main folder

List each team member and:
 * A description of their role(s) and responsibilities including the components they'll work on and non-software related work
 * 3 technical strengths and weaknesses each (e.g. languages, frameworks, libraries, development methodologies, etc.)
   - Ziyuan Gu: 
      - Role: Front End Developer
      - Responsibilities: Will mainly work with Android front end, and do scenario tests.
      - Strength: Java, Spring, .NET
      - Weakness: Infra, system code, DevOps

Xuhui Chen (Team Leader)
Haonan Gao

   - Yuelin Jiang:
     - Role: Front End Developer
     - Responsibilities: Will be working on the front-end part of the project, and dealing with front-end features like UI components and Screen Design. 
     - Strength: Python, C, SQL
     - Weakness: Java, IOS, React

   - Tong Su：
      - Role: Backend/ViewModel Designer
      - Responsibilities: 
      1. Design ViewModels for different activities
      2. Integrate use cases
      3. Manage UI state changes
      - Strength: Java, SQL, C
      - Weakness: Kotlin, Jetpack, Andriod
Ziyuan Gu
Yaowei Liu
Wenzhi Lin


#### Q7: What operational events will you have as a team?

Describe meetings (and other events) you are planning to have. 
 * When and where? Recurring or ad hoc? In-person or online?
 * What's the purpose of each meeting?
 * Other events could be coding sessions, code reviews, quick weekly sync meeting online, etc.
 * You should have at least 2 meetings with your project partner (if you have one) before D1 is due. Describe them here:
   * What did you discuss during the meetings?
   * What were the outcomes of each meeting?
   * You must keep track of meeting minutes and add them to your repo.
   * You must have a regular meeting schedule established by the second meeting.  

We plan to have a meeting among the group member at least twice a week, both online via Zoom / Google Meet.

  
#### Q8: What artifacts will you use to self-organize?

List/describe the artifacts you will produce in order to organize your team.       
 * Artifacts can be To-Do lists, Task boards, schedule(s), meeting minutes, etc.
 * We want to understand:
   * How do you keep track of what needs to get done?
   Have lists of tasks with proirities and deadlines to make sure we stay on top of our schedule.

   * **How do you prioritize tasks?**
   Tasks are prioritized based on dependency and urgency. For example, if a file is needed for the whole team to move on. This file is on top of our priority and is addressed as soon as possible. Or if we need to have a feature to be completed at a deadline, we would proitize to work on this feature and delay other unnecessary features.
   * How do tasks get assigned to team members?
   Tasks are assigned to each team member according to there role/experience, so everyone can work on the tasks they are good at.
   * How do you determine the status of work from inception to completion?
   We plan to have four status for each task in our team. Which are unassigned, assigned, need help, and completed. This way, we can keep track of the status of each task, and get help when we need.
#### Q9: What are the rules regarding how your team works?

Describe your team's working culture.

**Communications:**
 * What is the expected frequency? What methods/channels are appropriate? 
   - We expect to hold team meetings at least three times a week, and hold Partner meeting weekly at Monday night. And these meetings will be hold on Zoom. 
   - Besides these meetings, we have a private group chat that is used for real-time, quick communication.
 * If you have a partner project, what is your process (in detail) for communicating with your partner?
   - Our partner has decided to meet with us once a week on Zoom or Google Meeting. For short communication and announcement we will be sending emails.
 
**Meetings:**
 * How are people held accountable for attending meetings, completing action items? Is there a moderator or process?
   - We post group announcement in our group chat to remind everyone about the action items. Our team leader will be the moderator and be responsible for communicating with each individual regarding the attendace and work completion problem.

----
## Highlights

Specify 3 - 5 key decisions and/or insights that came up during your meetings
and/or collaborative process.

 * Short (5 min' read max)
 * Decisions can be related to the product and/or the team process.
    * Mention which alternatives you were considering.
    * Present the arguments for each alternative.
    * Explain why the option you decided on makes the most sense for your team/product/users.
 * Essentially, we want to understand how (and why) you ended up with your current product and process plan.
 * This section is useful for important information regarding your decision making process that may not necessarily fit in other sections. 

 1. During our discussion with our partner, we noticed that the target audience of the application may have difficult access to the internet. Thus we made the decision to make a majority of our application run offline. The only part of the app that requires internet is sending the workshop result to the teacher/insturctor. This design choice will allow people without stable access to the internet to utilize the application without compromising the user experience and help us to reach more target audiences.

2. During our team meeting, we made an agreement on the team structure. Our team will be separated into three small groups, which are front end group, back end group and database group. Each group will contain two to three person. But in the future, group size could change, people could be moved to a different group and the group work scope could also be modified. Therefore we can be flexible enough to maximize our productivity.

3. One of the key decisions that came up during our meeting with the project owner is to put down what we have in hand aside to attend the Water For The World Workshop. In the first meeting with the project owner, we found a serious problem. Our task is to design mobile phone software used to simulate the in-person workshop. Although the partner has done his best to describe the workshop, some details are still not very clear. In order to make our project closer to the real workshop, our group temporarily decided to participate in the most recent in-person workshop to understand the real situation. We believe that this can help us understand more about the project and to achieve better results.

4. Another decision we have made during our meeting is to use survey form to share results. During our meeting with John, he mentioned that he would like to receieve feedback from student about what do they learn and how the workshop could be improved. He suggested that the result could be sent through email. After the meeting, our group thought this app is not intended to collect any sensitive information from the user. If we use email, the users will need to type in their email account and password which is not ideal. Another issue may arise is that students may not have their email address and thus could not share their thoughts wuith the teacher. In that case, our team decided to use the survey form to replace the email for the feedback.  Students could write their feedback inside the app and the teacher will receive it in his/her side.

