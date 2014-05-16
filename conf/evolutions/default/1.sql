# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table album (
  id                        bigint not null,
  created                   timestamp,
  created_by_id             bigint,
  modified_by_id            bigint,
  constraint pk_album primary key (id))
;

create table barthel_index_form (
  id                        bigint not null,
  protocol_number           varchar(255),
  visit_date                timestamp,
  subject_initials          varchar(255),
  screening_number          integer,
  center_number             integer,
  created                   timestamp,
  constraint pk_barthel_index_form primary key (id))
;

create table comment (
  id                        bigint not null,
  message                   varchar(255),
  album_id                  bigint,
  commented_by_id           bigint,
  created_by_id             bigint,
  modified_by_id            bigint,
  created                   timestamp,
  constraint pk_comment primary key (id))
;

create table data_collection_form1 (
  id                        bigint not null,
  patient_id_number         integer,
  trial_site                varchar(255),
  recruited_date            timestamp,
  patient_name              varchar(255),
  date_of_birth             timestamp,
  patient_address           varchar(255),
  gender                    integer,
  landline_phone_number     varchar(255),
  cell_phone_number         varchar(255),
  friend_relative_phone_number varchar(255),
  place_of_birth            varchar(255),
  ethnicity                 varchar(255),
  native_language           varchar(255),
  religion                  varchar(255),
  blood_sample_taken        integer,
  blood_sample_date         timestamp,
  blood_sample_number       varchar(255),
  date_of_stroke            timestamp,
  created                   timestamp,
  constraint ck_data_collection_form1_gender check (gender in (0,1,2)),
  constraint ck_data_collection_form1_blood_sample_taken check (blood_sample_taken in (0,1,2,3)),
  constraint pk_data_collection_form1 primary key (id))
;

create table data_collection_form2 (
  id                        bigint not null,
  patient_id_number         integer,
  ischaemic_stroke          integer,
  hoemorrhagic_stroke       integer,
  venous_sinus_thrombosis   integer,
  tia                       integer,
  avm                       integer,
  aneurysm                  integer,
  subaranchoid              integer,
  hypertension              integer,
  diabetes_mellitus         integer,
  ihd_angina                integer,
  hypercholesterolemia      integer,
  atrial_fibrillation       integer,
  pvd                       integer,
  mi                        integer,
  migraine_with_aura        integer,
  migraine_without_aura     integer,
  ischaemic_stroke_year     integer,
  hoemorrhagic_stroke_year  integer,
  tia_year                  integer,
  stroke_associated_with_dissection integer,
  stroke_associated_with_pfo integer,
  stroke_associated_with_mi integer,
  family_stroke             integer,
  family_ihd_angina         integer,
  family_diabetes_mellitus  integer,
  family_mi                 integer,
  family_pvd                integer,
  family_hypertension       integer,
  family_none_of_the_above  integer,
  current_smoker            integer,
  cigarette_per_day         integer,
  ex_smoker                 integer,
  never                     integer,
  hip                       float,
  waist                     float,
  created                   timestamp,
  constraint ck_data_collection_form2_ischaemic_stroke check (ischaemic_stroke in (0,1,2,3)),
  constraint ck_data_collection_form2_hoemorrhagic_stroke check (hoemorrhagic_stroke in (0,1,2,3)),
  constraint ck_data_collection_form2_venous_sinus_thrombosis check (venous_sinus_thrombosis in (0,1,2,3)),
  constraint ck_data_collection_form2_tia check (tia in (0,1,2,3)),
  constraint ck_data_collection_form2_avm check (avm in (0,1,2,3)),
  constraint ck_data_collection_form2_aneurysm check (aneurysm in (0,1,2,3)),
  constraint ck_data_collection_form2_subaranchoid check (subaranchoid in (0,1,2,3)),
  constraint ck_data_collection_form2_hypertension check (hypertension in (0,1,2,3)),
  constraint ck_data_collection_form2_diabetes_mellitus check (diabetes_mellitus in (0,1,2,3)),
  constraint ck_data_collection_form2_ihd_angina check (ihd_angina in (0,1,2,3)),
  constraint ck_data_collection_form2_hypercholesterolemia check (hypercholesterolemia in (0,1,2,3)),
  constraint ck_data_collection_form2_atrial_fibrillation check (atrial_fibrillation in (0,1,2,3)),
  constraint ck_data_collection_form2_pvd check (pvd in (0,1,2,3)),
  constraint ck_data_collection_form2_mi check (mi in (0,1,2,3)),
  constraint ck_data_collection_form2_migraine_with_aura check (migraine_with_aura in (0,1,2,3)),
  constraint ck_data_collection_form2_migraine_without_aura check (migraine_without_aura in (0,1,2,3)),
  constraint ck_data_collection_form2_stroke_associated_with_dissection check (stroke_associated_with_dissection in (0,1,2,3)),
  constraint ck_data_collection_form2_stroke_associated_with_pfo check (stroke_associated_with_pfo in (0,1,2,3)),
  constraint ck_data_collection_form2_stroke_associated_with_mi check (stroke_associated_with_mi in (0,1,2,3)),
  constraint ck_data_collection_form2_family_stroke check (family_stroke in (0,1,2,3)),
  constraint ck_data_collection_form2_family_ihd_angina check (family_ihd_angina in (0,1,2,3)),
  constraint ck_data_collection_form2_family_diabetes_mellitus check (family_diabetes_mellitus in (0,1,2,3)),
  constraint ck_data_collection_form2_family_mi check (family_mi in (0,1,2,3)),
  constraint ck_data_collection_form2_family_pvd check (family_pvd in (0,1,2,3)),
  constraint ck_data_collection_form2_family_hypertension check (family_hypertension in (0,1,2,3)),
  constraint ck_data_collection_form2_family_none_of_the_above check (family_none_of_the_above in (0,1,2,3)),
  constraint ck_data_collection_form2_current_smoker check (current_smoker in (0,1,2,3)),
  constraint ck_data_collection_form2_ex_smoker check (ex_smoker in (0,1,2,3)),
  constraint ck_data_collection_form2_never check (never in (0,1,2,3)),
  constraint pk_data_collection_form2 primary key (id))
;

create table data_collection_form3 (
  id                        bigint not null,
  patient_id_number         integer,
  alcohol_units_per_week    integer,
  height                    float,
  weight                    float,
  bmi                       float,
  aspirin                   integer,
  aspirin_dosage            varchar(255),
  clopidogrel               integer,
  clopidogrel_dosage        varchar(255),
  aspirin_plus_clopidogrel  integer,
  aspirin_plus_clopidogrel_dosage varchar(255),
  dipyridamole              integer,
  dipyridamole_dosage       varchar(255),
  aspirin_plus_dipyridamole integer,
  aspirin_plus_dipyridamole_dosage varchar(255),
  warfarin                  integer,
  warfarin_inr              varchar(255),
  statin                    integer,
  statin_dosage             varchar(255),
  statin_name               varchar(255),
  antihypertensive          integer,
  antihypertensive_dosage   varchar(255),
  medicine_none_of_the_above integer,
  glucose_blood_test        integer,
  glucose_blood_test_result varchar(255),
  total_cholesterol_blood_test integer,
  total_cholesterol_blood_test_result varchar(255),
  hdl_cholesterol_blood_test integer,
  hdl_cholesterol_blood_test_result varchar(255),
  ldl_cholesterol_blood_test integer,
  ldl_cholesterol_blood_test_result varchar(255),
  triglyceride_blood_test   integer,
  triglyceride_blood_test_result varchar(255),
  esr_blood_test            integer,
  esr_blood_test_result     varchar(255),
  crp_blood_test            integer,
  crp_blood_test_result     varchar(255),
  troponim_blood_test       integer,
  troponim_blood_test_result varchar(255),
  protein_cblood_test       integer,
  protein_cblood_test_result varchar(255),
  protein_sblood_test       integer,
  protein_sblood_test_result varchar(255),
  fibrinogen_blood_test     integer,
  fibrinogen_blood_test_result varchar(255),
  antithrombin11blood_test  integer,
  antithrombin11blood_test_result varchar(255),
  factor_vblood_test        integer,
  factor_vblood_test_result varchar(255),
  homocysteine_blood_test   integer,
  homocysteine_blood_test_result varchar(255),
  prothrombin_blood_test    integer,
  prothrombin_blood_test_result varchar(255),
  antiphospholipid_blood_test integer,
  antiphospholipid_blood_test_result varchar(255),
  bp_on_admission           varchar(255),
  temperature_on_admission  varchar(255),
  carotid_endarterectomy_done integer,
  thrombolysed_done         integer,
  cta_done                  integer,
  mra_done                  integer,
  angiogram_done            integer,
  created                   timestamp,
  constraint ck_data_collection_form3_aspirin check (aspirin in (0,1,2,3)),
  constraint ck_data_collection_form3_clopidogrel check (clopidogrel in (0,1,2,3)),
  constraint ck_data_collection_form3_aspirin_plus_clopidogrel check (aspirin_plus_clopidogrel in (0,1,2,3)),
  constraint ck_data_collection_form3_dipyridamole check (dipyridamole in (0,1,2,3)),
  constraint ck_data_collection_form3_aspirin_plus_dipyridamole check (aspirin_plus_dipyridamole in (0,1,2,3)),
  constraint ck_data_collection_form3_warfarin check (warfarin in (0,1,2,3)),
  constraint ck_data_collection_form3_statin check (statin in (0,1,2,3)),
  constraint ck_data_collection_form3_antihypertensive check (antihypertensive in (0,1,2,3)),
  constraint ck_data_collection_form3_medicine_none_of_the_above check (medicine_none_of_the_above in (0,1,2,3)),
  constraint ck_data_collection_form3_glucose_blood_test check (glucose_blood_test in (0,1,2,3)),
  constraint ck_data_collection_form3_total_cholesterol_blood_test check (total_cholesterol_blood_test in (0,1,2,3)),
  constraint ck_data_collection_form3_hdl_cholesterol_blood_test check (hdl_cholesterol_blood_test in (0,1,2,3)),
  constraint ck_data_collection_form3_ldl_cholesterol_blood_test check (ldl_cholesterol_blood_test in (0,1,2,3)),
  constraint ck_data_collection_form3_triglyceride_blood_test check (triglyceride_blood_test in (0,1,2,3)),
  constraint ck_data_collection_form3_esr_blood_test check (esr_blood_test in (0,1,2,3)),
  constraint ck_data_collection_form3_crp_blood_test check (crp_blood_test in (0,1,2,3)),
  constraint ck_data_collection_form3_troponim_blood_test check (troponim_blood_test in (0,1,2,3)),
  constraint ck_data_collection_form3_protein_cblood_test check (protein_cblood_test in (0,1,2,3)),
  constraint ck_data_collection_form3_protein_sblood_test check (protein_sblood_test in (0,1,2,3)),
  constraint ck_data_collection_form3_fibrinogen_blood_test check (fibrinogen_blood_test in (0,1,2,3)),
  constraint ck_data_collection_form3_antithrombin11blood_test check (antithrombin11blood_test in (0,1,2,3)),
  constraint ck_data_collection_form3_factor_vblood_test check (factor_vblood_test in (0,1,2,3)),
  constraint ck_data_collection_form3_homocysteine_blood_test check (homocysteine_blood_test in (0,1,2,3)),
  constraint ck_data_collection_form3_prothrombin_blood_test check (prothrombin_blood_test in (0,1,2,3)),
  constraint ck_data_collection_form3_antiphospholipid_blood_test check (antiphospholipid_blood_test in (0,1,2,3)),
  constraint ck_data_collection_form3_carotid_endarterectomy_done check (carotid_endarterectomy_done in (0,1,2,3)),
  constraint ck_data_collection_form3_thrombolysed_done check (thrombolysed_done in (0,1,2,3)),
  constraint ck_data_collection_form3_cta_done check (cta_done in (0,1,2,3)),
  constraint ck_data_collection_form3_mra_done check (mra_done in (0,1,2,3)),
  constraint ck_data_collection_form3_angiogram_done check (angiogram_done in (0,1,2,3)),
  constraint pk_data_collection_form3 primary key (id))
;

create table data_collection_form4 (
  id                        bigint not null,
  patient_id_number         integer,
  intracranial_stenosis     integer,
  intracranial_stenosis_percent varchar(255),
  extracranial_dopplers_imaging_done integer,
  extracranial_mra_imaging_done integer,
  extracranial_cta_imaging_done integer,
  brain_ct_imaging_done     integer,
  brain_mri_imaging_done    integer,
  lesion_anterior           integer,
  lesion_right              integer,
  lesion_left               integer,
  lesion_bilateral          integer,
  lesion_posterior          integer,
  lesion_anterioposterior   integer,
  rica_stenosis_percent     float,
  lica_stenosis_percent     float,
  rcca_stenosis_percent     float,
  lcca_stenosis_percent     float,
  r_vertebral_stenosis_percent float,
  l_vertebral_stenosis_percent float,
  basilar_stenosis_percent  float,
  lvd                       integer,
  svd                       integer,
  cardioembolism            integer,
  combined                  integer,
  stroke_of_determined_etiology integer,
  negative_evaluation       integer,
  ecg_done                  integer,
  echo_done                 integer,
  ecg_normal                integer,
  ecg_lvh                   integer,
  ecg_af                    integer,
  ecg_ventricular_ectopics  integer,
  ecg_artial_ectopics       integer,
  ecg_none_of_above         integer,
  echo_normal               integer,
  echo_lvh                  integer,
  echo_pfo                  integer,
  echo_thrombus             integer,
  echo_none_of_above        integer,
  echo_dont_know            integer,
  ecg_dont_know             integer,
  nihss_on_admission        varchar(255),
  nihss_on_discharge        varchar(255),
  barthel_on_admission      varchar(255),
  barthel_on_discharge      varchar(255),
  home                      integer,
  nursing_home              integer,
  rehabilitation            integer,
  rip                       integer,
  local_dgh                 integer,
  created                   timestamp,
  constraint ck_data_collection_form4_intracranial_stenosis check (intracranial_stenosis in (0,1,2,3)),
  constraint ck_data_collection_form4_extracranial_dopplers_imaging_done check (extracranial_dopplers_imaging_done in (0,1,2,3)),
  constraint ck_data_collection_form4_extracranial_mra_imaging_done check (extracranial_mra_imaging_done in (0,1,2,3)),
  constraint ck_data_collection_form4_extracranial_cta_imaging_done check (extracranial_cta_imaging_done in (0,1,2,3)),
  constraint ck_data_collection_form4_brain_ct_imaging_done check (brain_ct_imaging_done in (0,1,2,3)),
  constraint ck_data_collection_form4_brain_mri_imaging_done check (brain_mri_imaging_done in (0,1,2,3)),
  constraint ck_data_collection_form4_lesion_anterior check (lesion_anterior in (0,1,2,3)),
  constraint ck_data_collection_form4_lesion_right check (lesion_right in (0,1,2,3)),
  constraint ck_data_collection_form4_lesion_left check (lesion_left in (0,1,2,3)),
  constraint ck_data_collection_form4_lesion_bilateral check (lesion_bilateral in (0,1,2,3)),
  constraint ck_data_collection_form4_lesion_posterior check (lesion_posterior in (0,1,2,3)),
  constraint ck_data_collection_form4_lesion_anterioposterior check (lesion_anterioposterior in (0,1,2,3)),
  constraint ck_data_collection_form4_lvd check (lvd in (0,1,2,3)),
  constraint ck_data_collection_form4_svd check (svd in (0,1,2,3)),
  constraint ck_data_collection_form4_cardioembolism check (cardioembolism in (0,1,2,3)),
  constraint ck_data_collection_form4_combined check (combined in (0,1,2,3)),
  constraint ck_data_collection_form4_stroke_of_determined_etiology check (stroke_of_determined_etiology in (0,1,2,3)),
  constraint ck_data_collection_form4_negative_evaluation check (negative_evaluation in (0,1,2,3)),
  constraint ck_data_collection_form4_ecg_done check (ecg_done in (0,1,2,3)),
  constraint ck_data_collection_form4_echo_done check (echo_done in (0,1,2,3)),
  constraint ck_data_collection_form4_ecg_normal check (ecg_normal in (0,1,2,3)),
  constraint ck_data_collection_form4_ecg_lvh check (ecg_lvh in (0,1,2,3)),
  constraint ck_data_collection_form4_ecg_af check (ecg_af in (0,1,2,3)),
  constraint ck_data_collection_form4_ecg_ventricular_ectopics check (ecg_ventricular_ectopics in (0,1,2,3)),
  constraint ck_data_collection_form4_ecg_artial_ectopics check (ecg_artial_ectopics in (0,1,2,3)),
  constraint ck_data_collection_form4_ecg_none_of_above check (ecg_none_of_above in (0,1,2,3)),
  constraint ck_data_collection_form4_echo_normal check (echo_normal in (0,1,2,3)),
  constraint ck_data_collection_form4_echo_lvh check (echo_lvh in (0,1,2,3)),
  constraint ck_data_collection_form4_echo_pfo check (echo_pfo in (0,1,2,3)),
  constraint ck_data_collection_form4_echo_thrombus check (echo_thrombus in (0,1,2,3)),
  constraint ck_data_collection_form4_echo_none_of_above check (echo_none_of_above in (0,1,2,3)),
  constraint ck_data_collection_form4_echo_dont_know check (echo_dont_know in (0,1,2,3)),
  constraint ck_data_collection_form4_ecg_dont_know check (ecg_dont_know in (0,1,2,3)),
  constraint ck_data_collection_form4_home check (home in (0,1,2,3)),
  constraint ck_data_collection_form4_nursing_home check (nursing_home in (0,1,2,3)),
  constraint ck_data_collection_form4_rehabilitation check (rehabilitation in (0,1,2,3)),
  constraint ck_data_collection_form4_rip check (rip in (0,1,2,3)),
  constraint ck_data_collection_form4_local_dgh check (local_dgh in (0,1,2,3)),
  constraint pk_data_collection_form4 primary key (id))
;

create table data_collection_form5 (
  id                        bigint not null,
  patient_id_number         integer,
  aspirin                   integer,
  aspirin_dosage            varchar(255),
  clopidogrel               integer,
  clopidogrel_dosage        varchar(255),
  aspirin_plus_clopidogrel  integer,
  aspirin_plus_clopidogrel_dosage varchar(255),
  dipyridamole              integer,
  dipyridamole_dosage       varchar(255),
  aspirin_plus_dipyridamole integer,
  aspirin_plus_dipyridamole_dosage varchar(255),
  warfarin                  integer,
  statin                    integer,
  statin_dosage             varchar(255),
  statin_name               varchar(255),
  antihypertensive          integer,
  spouse_name               varchar(255),
  spouse_address            varchar(255),
  spouse_date_of_birth      timestamp,
  spouse_gender             integer,
  spouse_landline_phone_number varchar(255),
  spouse_cell_phone_number  varchar(255),
  spouse_friend_phone_number varchar(255),
  spouse_place_of_birth     varchar(255),
  spouse_ethnicity          varchar(255),
  spouse_native_language    varchar(255),
  spouse_religion           varchar(255),
  spouse_hypertension       integer,
  spouse_diabetes_mellitus  integer,
  spouse_ihd_angina         integer,
  spouse_hypercholesterolemia integer,
  spouse_atrial_fibrillation integer,
  spouse_pvd                integer,
  spouse_mi                 integer,
  spouse_migraine_with_aura integer,
  spouse_migraine_without_aura integer,
  spouse_ischaemic_stroke   integer,
  spouse_hoemorrhagic_stroke integer,
  spouse_tia                integer,
  bp_today                  varchar(255),
  created                   timestamp,
  constraint ck_data_collection_form5_aspirin check (aspirin in (0,1,2,3)),
  constraint ck_data_collection_form5_clopidogrel check (clopidogrel in (0,1,2,3)),
  constraint ck_data_collection_form5_aspirin_plus_clopidogrel check (aspirin_plus_clopidogrel in (0,1,2,3)),
  constraint ck_data_collection_form5_dipyridamole check (dipyridamole in (0,1,2,3)),
  constraint ck_data_collection_form5_aspirin_plus_dipyridamole check (aspirin_plus_dipyridamole in (0,1,2,3)),
  constraint ck_data_collection_form5_warfarin check (warfarin in (0,1,2,3)),
  constraint ck_data_collection_form5_statin check (statin in (0,1,2,3)),
  constraint ck_data_collection_form5_antihypertensive check (antihypertensive in (0,1,2,3)),
  constraint ck_data_collection_form5_spouse_gender check (spouse_gender in (0,1,2)),
  constraint ck_data_collection_form5_spouse_hypertension check (spouse_hypertension in (0,1,2,3)),
  constraint ck_data_collection_form5_spouse_diabetes_mellitus check (spouse_diabetes_mellitus in (0,1,2,3)),
  constraint ck_data_collection_form5_spouse_ihd_angina check (spouse_ihd_angina in (0,1,2,3)),
  constraint ck_data_collection_form5_spouse_hypercholesterolemia check (spouse_hypercholesterolemia in (0,1,2,3)),
  constraint ck_data_collection_form5_spouse_atrial_fibrillation check (spouse_atrial_fibrillation in (0,1,2,3)),
  constraint ck_data_collection_form5_spouse_pvd check (spouse_pvd in (0,1,2,3)),
  constraint ck_data_collection_form5_spouse_mi check (spouse_mi in (0,1,2,3)),
  constraint ck_data_collection_form5_spouse_migraine_with_aura check (spouse_migraine_with_aura in (0,1,2,3)),
  constraint ck_data_collection_form5_spouse_migraine_without_aura check (spouse_migraine_without_aura in (0,1,2,3)),
  constraint ck_data_collection_form5_spouse_ischaemic_stroke check (spouse_ischaemic_stroke in (0,1,2,3)),
  constraint ck_data_collection_form5_spouse_hoemorrhagic_stroke check (spouse_hoemorrhagic_stroke in (0,1,2,3)),
  constraint ck_data_collection_form5_spouse_tia check (spouse_tia in (0,1,2,3)),
  constraint pk_data_collection_form5 primary key (id))
;

create table data_collection_form6 (
  id                        bigint not null,
  patient_id_number         integer,
  hip                       float,
  waist                     float,
  height                    float,
  weight                    float,
  bmi                       float,
  blood_sample_taken        integer,
  blood_sample_date         timestamp,
  blood_sample_number       varchar(255),
  created                   timestamp,
  constraint ck_data_collection_form6_blood_sample_taken check (blood_sample_taken in (0,1,2,3)),
  constraint pk_data_collection_form6 primary key (id))
;

create table economic_status (
  id                        bigint not null,
  name                      varchar(255),
  data_collection_form1_id  bigint,
  data_collection_form6_id  bigint,
  created                   timestamp,
  constraint pk_economic_status primary key (id))
;

create table image (
  id                        bigint not null,
  image_url                 varchar(255),
  album_id                  bigint,
  created                   timestamp,
  created_by_id             bigint,
  modified_by_id            bigint,
  constraint pk_image primary key (id))
;

create table login (
  id                        bigint not null,
  image_url                 varchar(255),
  created                   timestamp,
  created_by_id             bigint,
  modified_by_id            bigint,
  constraint pk_login primary key (id))
;

create table nihstroke_scale_form (
  id                        bigint not null,
  parent_identification     varchar(255),
  date_of_birth             timestamp,
  hospital                  varchar(255),
  date_of_exam              timestamp,
  interval                  varchar(255),
  time                      varchar(255),
  person_administering      varchar(255),
  created                   timestamp,
  constraint pk_nihstroke_scale_form primary key (id))
;

create table option (
  id                        bigint not null,
  name                      varchar(255),
  value                     varchar(255),
  question_id               bigint,
  created                   timestamp,
  constraint pk_option primary key (id))
;

create table patient (
  id                        bigint not null,
  full_name                 varchar(255),
  email                     varchar(255),
  age                       integer,
  gender                    integer,
  created                   timestamp,
  created_by_id             bigint,
  modified_by_id            bigint,
  constraint ck_patient_gender check (gender in (0,1,2)),
  constraint pk_patient primary key (id))
;

create table question (
  id                        bigint not null,
  name                      varchar(255),
  value                     varchar(255),
  created                   timestamp,
  constraint pk_question primary key (id))
;

create table review (
  id                        bigint not null,
  reviewed                  boolean,
  album_id                  bigint,
  assigned_to_id            bigint,
  created                   timestamp,
  created_by_id             bigint,
  modified_by_id            bigint,
  status                    integer,
  constraint ck_review_status check (status in (0,1,2)),
  constraint pk_review primary key (id))
;

create table o_user (
  id                        bigint not null,
  user_name                 varchar(255),
  password                  varchar(255),
  display_name              varchar(255),
  user_type                 integer,
  location                  varchar(255),
  phone                     varchar(255),
  created_by_id             bigint,
  modified_by_id            bigint,
  status                    integer,
  constraint ck_o_user_user_type check (user_type in (0,1,2)),
  constraint ck_o_user_status check (status in (0,1,2)),
  constraint pk_o_user primary key (id))
;

create sequence album_seq;

create sequence barthel_index_form_seq;

create sequence comment_seq;

create sequence data_collection_form1_seq;

create sequence data_collection_form2_seq;

create sequence data_collection_form3_seq;

create sequence data_collection_form4_seq;

create sequence data_collection_form5_seq;

create sequence data_collection_form6_seq;

create sequence economic_status_seq;

create sequence image_seq;

create sequence login_seq;

create sequence nihstroke_scale_form_seq;

create sequence option_seq;

create sequence patient_seq;

create sequence question_seq;

create sequence review_seq;

create sequence o_user_seq;

alter table album add constraint fk_album_createdBy_1 foreign key (created_by_id) references o_user (id);
create index ix_album_createdBy_1 on album (created_by_id);
alter table album add constraint fk_album_modifiedBy_2 foreign key (modified_by_id) references o_user (id);
create index ix_album_modifiedBy_2 on album (modified_by_id);
alter table comment add constraint fk_comment_album_3 foreign key (album_id) references album (id);
create index ix_comment_album_3 on comment (album_id);
alter table comment add constraint fk_comment_commentedBy_4 foreign key (commented_by_id) references o_user (id);
create index ix_comment_commentedBy_4 on comment (commented_by_id);
alter table comment add constraint fk_comment_createdBy_5 foreign key (created_by_id) references o_user (id);
create index ix_comment_createdBy_5 on comment (created_by_id);
alter table comment add constraint fk_comment_modifiedBy_6 foreign key (modified_by_id) references o_user (id);
create index ix_comment_modifiedBy_6 on comment (modified_by_id);
alter table economic_status add constraint fk_economic_status_dataCollect_7 foreign key (data_collection_form1_id) references data_collection_form1 (id);
create index ix_economic_status_dataCollect_7 on economic_status (data_collection_form1_id);
alter table economic_status add constraint fk_economic_status_dataCollect_8 foreign key (data_collection_form6_id) references data_collection_form6 (id);
create index ix_economic_status_dataCollect_8 on economic_status (data_collection_form6_id);
alter table image add constraint fk_image_album_9 foreign key (album_id) references album (id);
create index ix_image_album_9 on image (album_id);
alter table image add constraint fk_image_createdBy_10 foreign key (created_by_id) references o_user (id);
create index ix_image_createdBy_10 on image (created_by_id);
alter table image add constraint fk_image_modifiedBy_11 foreign key (modified_by_id) references o_user (id);
create index ix_image_modifiedBy_11 on image (modified_by_id);
alter table login add constraint fk_login_createdBy_12 foreign key (created_by_id) references o_user (id);
create index ix_login_createdBy_12 on login (created_by_id);
alter table login add constraint fk_login_modifiedBy_13 foreign key (modified_by_id) references o_user (id);
create index ix_login_modifiedBy_13 on login (modified_by_id);
alter table option add constraint fk_option_question_14 foreign key (question_id) references question (id);
create index ix_option_question_14 on option (question_id);
alter table patient add constraint fk_patient_createdBy_15 foreign key (created_by_id) references o_user (id);
create index ix_patient_createdBy_15 on patient (created_by_id);
alter table patient add constraint fk_patient_modifiedBy_16 foreign key (modified_by_id) references o_user (id);
create index ix_patient_modifiedBy_16 on patient (modified_by_id);
alter table review add constraint fk_review_album_17 foreign key (album_id) references album (id);
create index ix_review_album_17 on review (album_id);
alter table review add constraint fk_review_assignedTo_18 foreign key (assigned_to_id) references o_user (id);
create index ix_review_assignedTo_18 on review (assigned_to_id);
alter table review add constraint fk_review_createdBy_19 foreign key (created_by_id) references o_user (id);
create index ix_review_createdBy_19 on review (created_by_id);
alter table review add constraint fk_review_modifiedBy_20 foreign key (modified_by_id) references o_user (id);
create index ix_review_modifiedBy_20 on review (modified_by_id);
alter table o_user add constraint fk_o_user_createdBy_21 foreign key (created_by_id) references o_user (id);
create index ix_o_user_createdBy_21 on o_user (created_by_id);
alter table o_user add constraint fk_o_user_modifiedBy_22 foreign key (modified_by_id) references o_user (id);
create index ix_o_user_modifiedBy_22 on o_user (modified_by_id);



# --- !Downs

drop table if exists album cascade;

drop table if exists barthel_index_form cascade;

drop table if exists comment cascade;

drop table if exists data_collection_form1 cascade;

drop table if exists data_collection_form2 cascade;

drop table if exists data_collection_form3 cascade;

drop table if exists data_collection_form4 cascade;

drop table if exists data_collection_form5 cascade;

drop table if exists data_collection_form6 cascade;

drop table if exists economic_status cascade;

drop table if exists image cascade;

drop table if exists login cascade;

drop table if exists nihstroke_scale_form cascade;

drop table if exists option cascade;

drop table if exists patient cascade;

drop table if exists question cascade;

drop table if exists review cascade;

drop table if exists o_user cascade;

drop sequence if exists album_seq;

drop sequence if exists barthel_index_form_seq;

drop sequence if exists comment_seq;

drop sequence if exists data_collection_form1_seq;

drop sequence if exists data_collection_form2_seq;

drop sequence if exists data_collection_form3_seq;

drop sequence if exists data_collection_form4_seq;

drop sequence if exists data_collection_form5_seq;

drop sequence if exists data_collection_form6_seq;

drop sequence if exists economic_status_seq;

drop sequence if exists image_seq;

drop sequence if exists login_seq;

drop sequence if exists nihstroke_scale_form_seq;

drop sequence if exists option_seq;

drop sequence if exists patient_seq;

drop sequence if exists question_seq;

drop sequence if exists review_seq;

drop sequence if exists o_user_seq;

