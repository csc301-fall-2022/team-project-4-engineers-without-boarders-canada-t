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

  > Short (1 - 2 min' read max)
 * Be specific (e.g. a 'a third-year university student studying Computer Science' and not 'a student')
 * **Feel free to use personas. You can create your personas as part of this Markdown file, or add a link to an external site (for example, [Xtensio](https://xtensio.com/user-persona/)).**

#### Q3: Why would your users choose your product? What are they using today to solve their problem/need?

> Short (1 - 2 min' read max)
 * We want you to "connect the dots" for us - Why does your product (as described in your answer to Q1) fits the needs of your users (as described in your answer to Q2)?
 * Explain the benefits of your product explicitly & clearly. For example:
    * Save users time (how much?)
    * Allow users to discover new information (which information? And, why couldn't they discover it before?)
    * Provide users with more accurate and/or informative data (what kind of data? Why is it useful to them?)
    * Does this application exist in another form? If so, how does your differ and provide value to the users?
    * How does this align with your partner's organization's values/mission/mandate?

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

Xuhui Chen (Team Leader)
Haonan Gao
Yuelin Jiang
Tong Su
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
 * If you have a partner project, what is your process (in detail) for communicating with your partner?
 
**Meetings:**
 * How are people held accountable for attending meetings, completing action items? Is there a moderator or process?


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
