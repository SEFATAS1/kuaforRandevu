import { useEffect, useMemo, useState } from "react";
import { signUp } from "@/pages/SignUp/api";
import { Input } from "@/shared/Components/Input";
import { Alert } from "@/shared/components/Alert";
import { Spinner } from "@/shared/components/Spinner";
import { Button } from "@/shared/components/Button";

export function SignUp() {
  const [firstName, setFirstName] = useState();
  const [lastName, setLastName] = useState();
  const [phone, setPhone] = useState();
  const [email, setEmail] = useState();
  const [password, setPassword] = useState();
  const [passwordRepeat, setPasswordRepeat] = useState();
  const [userRoleId, setUserRoleId] = useState();
  const [apiProgress, setApiProgress] = useState(false);
  const [successMessage, setSuccessMessage] = useState();
  const [errors, setErrors] = useState({});
  const [generalError, setGeneralError] = useState();

  useEffect(() => {
    setErrors(function (lastErrors) {
      return {
        ...lastErrors,
        firstName: undefined,
      };
    });
  }, [firstName]);

  useEffect(() => {
    setErrors(function (lastErrors) {
      return {
        ...lastErrors,
        email: undefined,
      };
    });
  }, [email]);

  useEffect(() => {
    setErrors(function (lastErrors) {
      return {
        ...lastErrors,
        password: undefined,
      };
    });
  }, [password]);

  const onSubmit = async (event) => {
    event.preventDefault();
    setSuccessMessage();
    setGeneralError();
    setApiProgress(true);

    try {
      const response = await signUp({
        firstName,
        lastName,
        phone,
        email,
        password,
        userRoleId: 3,
      });
      setSuccessMessage(response.data.message);
    } catch (axiosError) {
      if (axiosError.response?.data) {
        if (axiosError.response.data === 500) {
          setErrors(axiosError.response.data.validationsErrors);
        } else {
          setGeneralError(axiosError.response.data.message);
        }
      } else {
        setGeneralError("genericError");
      }
    } finally {
      setApiProgress(false);
    }
  };

  const passwordRepeatError = useMemo(() => {
    if (password && password !== passwordRepeat) {
      return "password Mismatch";
    }
    return "";
  }, [password, passwordRepeat]);

  return (
    <div className="container">
      <div className="col-lg-6 offset-lg-3 col-sm-8 offset-sm-2">
        <form className="card" onSubmit={onSubmit}>
          <div className="text-center card-header">
            <h1>Sign Up</h1>
          </div>
          <div className="card-body">
            <Input
              id="fistName"
              label="First Name"
              error={errors.firstName}
              onChange={(event) => setFirstName(event.target.value)}
              type="text"
            />
            <Input
              id="lastName"
              label="Last Name"
              onChange={(event) => setLastName(event.target.value)}
              type="text"
            />
            <Input
              id="phone"
              label="Phone"
              error={errors.phone}
              onChange={(event) => setPhone(event.target.value)}
              type="text"
            />
            <Input
              id="email"
              label="E-mail"
              error={errors.email}
              onChange={(event) => setEmail(event.target.value)}
              type="text"
            />
            <Input
              id="password"
              label="Password"
              error={errors.password}
              onChange={(event) => setPassword(event.target.value)}
              type="password"
            />
            <Input
              id="passwordRepeat"
              label="Password Repeat"
              error={passwordRepeatError}
              onChange={(event) => setPasswordRepeat(event.target.value)}
              type="password"
            />
            {successMessage && <Alert>{successMessage}</Alert>}
            {generalError && <Alert styleType="danger">{generalError}</Alert>}
            <div className="text-center">
              <Button
                disabled={!password || password !== passwordRepeat}
                apiProgress={apiProgress}
              >
                Sign Up
              </Button>
            </div>
          </div>
        </form>
      </div>
    </div>
  );
}
