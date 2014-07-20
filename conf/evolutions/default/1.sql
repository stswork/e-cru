# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

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

create table data_collection_form1 (
  id                        bigint not null,
  patient_id_number         bigint,
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
  status                    integer,
  created_by_id             bigint,
  modified_by_id            bigint,
  data_collection_form2_id  bigint,
  data_collection_form3_id  bigint,
  data_collection_form4_id  bigint,
  data_collection_form5_id  bigint,
  data_collection_form6_id  bigint,
  created                   timestamp,
  constraint ck_data_collection_form1_gender check (gender in (0,1,2)),
  constraint ck_data_collection_form1_blood_sample_taken check (blood_sample_taken in (0,1,2,3)),
  constraint ck_data_collection_form1_status check (status in (0,1,2)),
  constraint pk_data_collection_form1 primary key (id))
;

create table data_collection_form2 (
  id                        bigint not null,
  patient_id_number         bigint,
  ischaemic_stroke          integer,
  taci                      integer,
  paci                      integer,
  laci                      integer,
  poci                      integer,
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
  status                    integer,
  created_by_id             bigint,
  modified_by_id            bigint,
  created                   timestamp,
  constraint ck_data_collection_form2_ischaemic_stroke check (ischaemic_stroke in (0,1,2,3)),
  constraint ck_data_collection_form2_taci check (taci in (0,1,2,3)),
  constraint ck_data_collection_form2_paci check (paci in (0,1,2,3)),
  constraint ck_data_collection_form2_laci check (laci in (0,1,2,3)),
  constraint ck_data_collection_form2_poci check (poci in (0,1,2,3)),
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
  constraint ck_data_collection_form2_status check (status in (0,1,2)),
  constraint pk_data_collection_form2 primary key (id))
;

create table data_collection_form3 (
  id                        bigint not null,
  patient_id_number         bigint,
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
  status                    integer,
  created_by_id             bigint,
  modified_by_id            bigint,
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
  constraint ck_data_collection_form3_status check (status in (0,1,2)),
  constraint pk_data_collection_form3 primary key (id))
;

create table data_collection_form4 (
  id                        bigint not null,
  patient_id_number         bigint,
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
  status                    integer,
  created_by_id             bigint,
  modified_by_id            bigint,
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
  constraint ck_data_collection_form4_status check (status in (0,1,2)),
  constraint pk_data_collection_form4 primary key (id))
;

create table data_collection_form5 (
  id                        bigint not null,
  patient_id_number         bigint,
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
  status                    integer,
  created_by_id             bigint,
  modified_by_id            bigint,
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
  constraint ck_data_collection_form5_status check (status in (0,1,2)),
  constraint pk_data_collection_form5 primary key (id))
;

create table data_collection_form6 (
  id                        bigint not null,
  patient_id_number         bigint,
  hip                       float,
  waist                     float,
  height                    float,
  weight                    float,
  bmi                       float,
  blood_sample_taken        integer,
  blood_sample_date         timestamp,
  blood_sample_number       varchar(255),
  status                    integer,
  created_by_id             bigint,
  modified_by_id            bigint,
  created                   timestamp,
  constraint ck_data_collection_form6_blood_sample_taken check (blood_sample_taken in (0,1,2,3)),
  constraint ck_data_collection_form6_status check (status in (0,1,2)),
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

create table s3file (
  id                        varchar(40) not null,
  bucket                    varchar(255),
  name                      varchar(255),
  constraint pk_s3file primary key (id))
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

create sequence barthel_index_form_seq;

create sequence data_collection_form1_seq;

create sequence data_collection_form2_seq;

create sequence data_collection_form3_seq;

create sequence data_collection_form4_seq;

create sequence data_collection_form5_seq;

create sequence data_collection_form6_seq;

create sequence economic_status_seq;

create sequence nihstroke_scale_form_seq;

create sequence o_user_seq;

alter table data_collection_form1 add constraint fk_data_collection_form1_creat_1 foreign key (created_by_id) references o_user (id);
create index ix_data_collection_form1_creat_1 on data_collection_form1 (created_by_id);
alter table data_collection_form1 add constraint fk_data_collection_form1_modif_2 foreign key (modified_by_id) references o_user (id);
create index ix_data_collection_form1_modif_2 on data_collection_form1 (modified_by_id);
alter table data_collection_form1 add constraint fk_data_collection_form1_dataC_3 foreign key (data_collection_form2_id) references data_collection_form2 (id);
create index ix_data_collection_form1_dataC_3 on data_collection_form1 (data_collection_form2_id);
alter table data_collection_form1 add constraint fk_data_collection_form1_dataC_4 foreign key (data_collection_form3_id) references data_collection_form3 (id);
create index ix_data_collection_form1_dataC_4 on data_collection_form1 (data_collection_form3_id);
alter table data_collection_form1 add constraint fk_data_collection_form1_dataC_5 foreign key (data_collection_form4_id) references data_collection_form4 (id);
create index ix_data_collection_form1_dataC_5 on data_collection_form1 (data_collection_form4_id);
alter table data_collection_form1 add constraint fk_data_collection_form1_dataC_6 foreign key (data_collection_form5_id) references data_collection_form5 (id);
create index ix_data_collection_form1_dataC_6 on data_collection_form1 (data_collection_form5_id);
alter table data_collection_form1 add constraint fk_data_collection_form1_dataC_7 foreign key (data_collection_form6_id) references data_collection_form6 (id);
create index ix_data_collection_form1_dataC_7 on data_collection_form1 (data_collection_form6_id);
alter table data_collection_form2 add constraint fk_data_collection_form2_creat_8 foreign key (created_by_id) references o_user (id);
create index ix_data_collection_form2_creat_8 on data_collection_form2 (created_by_id);
alter table data_collection_form2 add constraint fk_data_collection_form2_modif_9 foreign key (modified_by_id) references o_user (id);
create index ix_data_collection_form2_modif_9 on data_collection_form2 (modified_by_id);
alter table data_collection_form3 add constraint fk_data_collection_form3_crea_10 foreign key (created_by_id) references o_user (id);
create index ix_data_collection_form3_crea_10 on data_collection_form3 (created_by_id);
alter table data_collection_form3 add constraint fk_data_collection_form3_modi_11 foreign key (modified_by_id) references o_user (id);
create index ix_data_collection_form3_modi_11 on data_collection_form3 (modified_by_id);
alter table data_collection_form4 add constraint fk_data_collection_form4_crea_12 foreign key (created_by_id) references o_user (id);
create index ix_data_collection_form4_crea_12 on data_collection_form4 (created_by_id);
alter table data_collection_form4 add constraint fk_data_collection_form4_modi_13 foreign key (modified_by_id) references o_user (id);
create index ix_data_collection_form4_modi_13 on data_collection_form4 (modified_by_id);
alter table data_collection_form5 add constraint fk_data_collection_form5_crea_14 foreign key (created_by_id) references o_user (id);
create index ix_data_collection_form5_crea_14 on data_collection_form5 (created_by_id);
alter table data_collection_form5 add constraint fk_data_collection_form5_modi_15 foreign key (modified_by_id) references o_user (id);
create index ix_data_collection_form5_modi_15 on data_collection_form5 (modified_by_id);
alter table data_collection_form6 add constraint fk_data_collection_form6_crea_16 foreign key (created_by_id) references o_user (id);
create index ix_data_collection_form6_crea_16 on data_collection_form6 (created_by_id);
alter table data_collection_form6 add constraint fk_data_collection_form6_modi_17 foreign key (modified_by_id) references o_user (id);
create index ix_data_collection_form6_modi_17 on data_collection_form6 (modified_by_id);
alter table economic_status add constraint fk_economic_status_dataCollec_18 foreign key (data_collection_form1_id) references data_collection_form1 (id);
create index ix_economic_status_dataCollec_18 on economic_status (data_collection_form1_id);
alter table economic_status add constraint fk_economic_status_dataCollec_19 foreign key (data_collection_form6_id) references data_collection_form6 (id);
create index ix_economic_status_dataCollec_19 on economic_status (data_collection_form6_id);
alter table o_user add constraint fk_o_user_createdBy_20 foreign key (created_by_id) references o_user (id);
create index ix_o_user_createdBy_20 on o_user (created_by_id);
alter table o_user add constraint fk_o_user_modifiedBy_21 foreign key (modified_by_id) references o_user (id);
create index ix_o_user_modifiedBy_21 on o_user (modified_by_id);



# --- !Downs

drop table if exists barthel_index_form cascade;

drop table if exists data_collection_form1 cascade;

drop table if exists data_collection_form2 cascade;

drop table if exists data_collection_form3 cascade;

drop table if exists data_collection_form4 cascade;

drop table if exists data_collection_form5 cascade;

drop table if exists data_collection_form6 cascade;

drop table if exists economic_status cascade;

drop table if exists nihstroke_scale_form cascade;

drop table if exists s3file cascade;

drop table if exists o_user cascade;

drop sequence if exists barthel_index_form_seq;

drop sequence if exists data_collection_form1_seq;

drop sequence if exists data_collection_form2_seq;

drop sequence if exists data_collection_form3_seq;

drop sequence if exists data_collection_form4_seq;

drop sequence if exists data_collection_form5_seq;

drop sequence if exists data_collection_form6_seq;

drop sequence if exists economic_status_seq;

drop sequence if exists nihstroke_scale_form_seq;

drop sequence if exists o_user_seq;

